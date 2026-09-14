import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 진출 기준 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        // 제일 먼저 나가는 차 기준으로 해야 함.
        int fastOut = routes[0][1];
        int answer = 1;
        
        for(int i = 1; i < routes.length; i++) {
            int in = routes[i][0];
            int out = routes[i][1];
            
            if(fastOut < in) {
                answer++;
                fastOut = out;
            }
        }
        return answer;
    }
}

/*
제일 빨리 나가는 차 기준으로 설치해야 함.
[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]

정렬하면 (in, out)
[-20, -15], [-18, -13], [-14, -5], [-5, -3]

-15 지점에 하나 일단 해야 함.
그러다가 in이 -14인 곳 만나면 out을 -5로 변경

*/