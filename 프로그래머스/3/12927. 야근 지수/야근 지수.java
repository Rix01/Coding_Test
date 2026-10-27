import java.io.*;
import java.util.*;

// 1. works 합이 n보다 작으면 0리턴
// 2. works를 정렬 -> 가장 큰 수부터 나오게 정렬 (우선순위 큐 쓰기)
// 매 순간마다 가장 큰 값이 앞에 오도록 해서 거기에서 빼줌
// 그 다음에 제곱해서 더하기

class Solution {
    public long solution(int n, int[] works) {
        
        // works 합 구하기
        int workHap = 0;
        for(int work:works) {
            workHap += work;
        }
        if(workHap <= n) {
            return 0;
        }
        
        // ------------------------
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 큰 수가 가장 먼저 나오게 세팅
        for(int work:works) {
            pq.add(work);
        }
        
        for(int i = 0; i < n; i++) {
            int top = pq.peek();
            pq.remove();
            top--;
            pq.add(top);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            long top = (long)pq.peek();
            pq.remove();
            answer += top*top;
        }

        return answer;
    }
}

/*
4시간동안 야근
남은 일의 작업량이 [4,3,3]

남은 일의 작업량을 제곱하여 더한 값
4시간동안 일할 건데 1시간동안 작업량을 1만큼 처리

즉 총합 4만큼 빠질 건데

---

1시간동안 야근
1 1 2

---

3시간 동안 야근
남은 works

---



*/