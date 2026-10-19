import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        
        // 큐 형태로 변환하는 메서드
        Deque<Integer> q1 = convertQ(queue1);
        Deque<Integer> q2 = convertQ(queue2);
        
        // 각 큐 안의 원소 합 구하는 메서드
        long qHap1 = calculateHap(q1);
        long qHap2 = calculateHap(q2);
        
        // 합이 홀수이면 -1 빠르게 리턴
        if((qHap1 + qHap2) % 2 == 1) {
            return -1;
        }
        
        boolean flag = false;
        int count = 0;
        while(true) {            
            
            // 두 큐 중 더 큰 곳의 인덱스 구하기
            int biggerIdx = findBig(qHap1, qHap2);
            
            if(biggerIdx == 0 || q1.isEmpty() || q2.isEmpty() || count > queue1.length *4) {
                if(biggerIdx == 0) {
                    return count;
                }
                break;
            }
            
            // 첫 번째 큐가 더 큰 경우
            if(biggerIdx == 1) {
                int popNow = q1.pollFirst();
                q2.addLast(popNow);
                count++;
                qHap1 -= popNow;
                qHap2 += popNow;
                continue;
            }
            
            // 두 번째 큐가 더 큰 경우
            if(biggerIdx == 2) {
                int popNow = q2.pollFirst();
                q1.addLast(popNow);
                count++;
                qHap2 -= popNow;
                qHap1 += popNow;
                continue;
            }
        }
        
        return -1;
    }
    
    public Deque<Integer> convertQ(int[] queue) {
        Deque<Integer> answer = new ArrayDeque<>();
        for(int q:queue) {
            answer.addLast(q);
        }
        return answer;
    }
    
    public long calculateHap(Deque<Integer> queue) {
        long hap = 0L;
        for (int now : queue) {
            hap += now;
        }
        return hap;
    }
    
    public int findBig(long qHap1, long qHap2) {
        if(qHap1 > qHap2) {
            return 1;
        }
        if(qHap2 > qHap1) {
            return 2;
        }
        return 0;
    }
}