import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // 2번째 요소 기준 정렬
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        // 첫 미사일 무조건 요격해야 함
        int fastest = targets[0][1];
        int answer = 1;
        
        for(int i = 1; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];
            
            if(fastest <= s) {
                answer++;
                fastest = e;
            }
        }
        return answer;
    }
}