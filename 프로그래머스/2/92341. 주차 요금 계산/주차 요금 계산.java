import java.io.*;
import java.util.*;

class Solution {
    Map<String, List<Record>> map = new HashMap<>();
    Map<String, Integer> totalTimeMap = new HashMap<>();
    int[] fees;
    
    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;
        
        // Map<String, List<Record>>에 넣기
        for(String record : records) {
            String[] splitRecord = record.split(" ");
            String carNumber = splitRecord[1];            
            Record r = new Record(splitRecord[0], splitRecord[2]);
            // 처음 들어오는 기록의 차라면
            if(!map.containsKey(carNumber)) {
                List<Record> newRecord = new ArrayList<>();
                newRecord.add(r);
                map.put(carNumber, newRecord);
            }
            // 있는 기록의 차라면
            else {
                List<Record> presentRecord = map.get(carNumber);
                presentRecord.add(r);
            }
        }
        
        // Map 크기만큼 result 세팅
        int[] answer = new int[map.size()];
        
        // Map 키에서 돌면서 총합 분 계산
        for(String car:map.keySet()) {
            int totalTime = calculateTotalTime(map.get(car));
            totalTimeMap.put(car, totalTime);
        }
        
        // fee에 따라 계산
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        
        int idx = 0;
        for(String carNumber: keyList) {
            answer[idx] = calculateFee(totalTimeMap.get(carNumber));
            idx++;
        }
        
        return answer;
    }
    
    class Record {
        String time;
        String inOut;
        
        Record(String time, String inOut) {
            this.time = time;
            this.inOut = inOut;
        }
    }
    
    public int calculateTotalTime(List<Record> recordList) {
        
        // 홀수이면 23:59, OUT 넣기
        if(recordList.size() % 2 == 1) {
            recordList.add(new Record("23:59", "OUT"));
        }
        
        int answer = 0;
        
        // 돌면서 계산 IN, OUT 페어
        for(int i = 0; i < recordList.size(); i+=2) {
            String[] inTime = recordList.get(i).time.split(":");
            String[] outTime = recordList.get(i+1).time.split(":");
            
            int inHour = Integer.parseInt(inTime[0]);
            int inMinute = Integer.parseInt(inTime[1]);
            
            int outHour = Integer.parseInt(outTime[0]);
            int outMinute = Integer.parseInt(outTime[1]);
            
            
            // 음수이면
            if(outMinute - inMinute < 0) {
                outHour -= 1;
                answer += (outMinute - inMinute + 60) + ((outHour - inHour) * 60);
            }
            
            else {
                answer += (outMinute - inMinute) + ((outHour - inHour) * 60);
            }
        }
        
        return answer;
    }
    
    public int calculateFee(int totalTime) {
        int totalTimeMax = Math.max(totalTime - fees[0], 0); // 음수 방지
        int answer = fees[1] + (int) (Math.ceil((double) (totalTimeMax) / fees[2])) * fees[3];
            
        return answer;
    }
}

/*
입력에 fees는
기본 시간, 기본 요금, 단위 시간, 단위 요금을 가지고 있음

records는 입/출차 기록
시각, 차량번호, 내역(입차/출차)

자동차별 주차 요금
0000은 34분 주차.


<알아야 할 요구사항>
- 입차 후 출차 기록 없으면 23:59에 출차된 것으로 간주
    - 0000 18:59부터 23:59
- 나누어 떨어지지 않으면 올림
- 차량 번호가 작은 자동차부터 청구할 주차 요금 차례대로 정수 배열에 담아서 return


<예시 분석>
예제1)
0000 0148 5961 순으로 출력
0000은 34분 + 5시간 = 34분 + 300분 = 334분
>> 기본 요금 + [(총합 분 - 기본 분) / 단위 분] * 단위 요금 = 14600

<구현 계획>
1. Map<String, List<Record>>에 넣기
2. Map 크기만큼 result 세팅
3. Map keySet 뽑아서 순서대로 계산 후에 result에 넣기

*/