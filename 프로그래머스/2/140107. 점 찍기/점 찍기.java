import java.io.*;
import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dSquare = (long) d * d;

        // x를 0부터 d 이하까지 k씩 증가
        for (long x = 0; x <= d; x += k) {
            long xSquare = x * x;
            
            // x가 고정일 때 가능한 y의 최댓값
            long maxY = (long) Math.sqrt(dSquare - xSquare);
            
            // 0부터 maxY 사이에서 k의 배수의 개수 (+1은 y=0인 경우)
            answer += (maxY / k) + 1;
        }

        return answer;
    }
}
