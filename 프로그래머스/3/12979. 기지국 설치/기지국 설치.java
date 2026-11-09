import java.io.*;
import java.util.*;

class Solution {
    List<Integer> notColored = new ArrayList<>(); // 칠해지지 않은 곳 얼마나 연속되어 있는지
    
    public int solution(int n, int[] stations, int w) {
        int idx = 1;
        
        for(int station:stations) {
            // 처음 닿는 위치
            int start = station - w;
            
            // idx = 1 ~ 닿는 위치까지의 빈 공간
            if(idx < start) {
                int count = start - idx;
                notColored.add(count);
            }
            
            // 전파 끝나는 다음 번호로 idx 점프
            idx = station + w + 1;
        }
        
        // 마지막 기지국 전파 끝 다음부터 아파트 끝까지 남은 빈 공간 있을 경우
        if(idx <= n) {
            int count = n - idx + 1;
            notColored.add(count);
        }
        
        int answer = 0;
        
        for(int not:notColored) {
            if(not % (2*w + 1) == 0) {
                answer += (not / (2*w + 1));
            } 
            else {
                double divide = (double)not / (2*w + 1);
                answer += (int)(Math.ceil(divide));
            }
        }

        return answer;
    }
}