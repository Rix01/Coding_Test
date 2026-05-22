import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 정렬 후에, 맨 뒤에 있는 게 가장 긴 시간이 걸리는 입국심사대임.
        Arrays.sort(times);
        long maxTime = (long) times[times.length-1] * n;
        
        long left = 1;
        long right = maxTime;
        long mid = (left + right) / 2;
        long answer = 0;
        
        // --------------------
        
        while(left <= right) {
            long possiblePerson = 0;
            for(int i = 0; i < times.length; i++) {
                possiblePerson += mid / times[i];
            }
            
            // 위 조건 만족 못하면 계속 진행
            if(possiblePerson < n) {
                // 늘려야 함
                left = mid + 1;
            } else if(possiblePerson >= n) {
                // 가능한 값이어도 더 줄이면 최소값이 나올 수 있으므로
                answer = mid;
                // 줄여야 함
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
    
        return answer;
    }
}