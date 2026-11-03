import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // A 배열, B 배열 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        int aIdx = 0;
        int bIdx = 0;
        while(bIdx < B.length) {
            if(B[bIdx] > A[aIdx]) {
                aIdx++;
                bIdx++;
                answer++;
            }
            
            else {
                bIdx++;
            }
        }
        
        return answer;
    }
}

// 10억이라..
// A 배열 정렬
// B 배열도 정렬
// A 현재 위치에 있는 수보다 큰 수부터 배치할 것임. 없으면 끝남.