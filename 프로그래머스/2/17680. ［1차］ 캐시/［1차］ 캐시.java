import java.io.*;
import java.util.*;

class Solution {
    Map<String, Integer> map;
    
    public int solution(int cacheSize, String[] cities) {   
        // 모두 다 소문자로 변경
        String[] lowerCities = new String[cities.length];
        for(int i = 0 ; i < cities.length; i++) {
            lowerCities[i] = cities[i].toLowerCase();
        }
        
        this.map = new LinkedHashMap<>(cacheSize);
        
        int answer = 0;
        
        boolean flag = true;
        if(cacheSize == 0) {
            answer = cities.length * 5;
            flag = false;
        }
        
        if(flag) {
            for(int i = 0; i < lowerCities.length; i++) {
            // 가지고 있다면
            if(map.containsKey(lowerCities[i])) {
                answer += 1;
                // 빼서 뒤로 넣기
                map.remove(lowerCities[i]);
                map.put(lowerCities[i], 0);
            }
            
            // 가지고 있지 않다면
            else {
                answer += 5;
                
                // 사이즈를 넘었다면
                if(map.size() >= cacheSize) {
                    // 첫번째 키 값 가져오기
                    String firstKey = map.keySet().iterator().next();
                    // 삭제 후 새로운 값 넣기
                    map.remove(firstKey); 
                    map.put(lowerCities[i], 0);
                }
                
                // 사이즈를 안 넘었다면
                else {
                    map.put(lowerCities[i], 0);
                }
            }
        }
    }
        
        
        return answer;
    }
}

/*
도시 이름 검색 -> 맛집 게시물들 읽어서 보여주는 서비스 개발

DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램

입력
cacheSize 
cities 10만개

총 실행시간

LRU 사용한다.
Least Recently Used
가장 오랫동안 참조되지 않은 데이터를 먼저 삭제

cache hit 1
cache miss 5

3	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	50

- Seoul, Pangyo, Jeju 15
- NewYork, Seoul, Pangyo 20
- LA, NewYork, Seoul 25
- Jeju, LA, NewYork 30
- Pangyo, Jeju, LA 35
- Seoul, Pangyo, Jeju 40
- NewYork, Seoul, Pangyo 45


3	["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	21

- Seoul, Pangyo, Jeju 15
- Jeju, Seoul, Pangyo 16
- Seoul, Jeju, Pangyo 17 *
- Jeju, Seoul, Pangyo 18
- Pangyo, Jeju, Seoul 19
- 

뭐 사실 그냥 뒤에 해도 되니까
- Jeju, Pangyo, Seoul
- Pangyo, Seoul, Jeju
- Seoul, Jeju, Pangyo
- Jeju, Pangyo, Seoul
- Pangyo, Seoul, Jeju
..
이런 식으로

삽입, 삭제가 빈번하게 일어나는 경우니까 링크드리스트?
LinkedHashMap




*/