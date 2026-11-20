import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length - 1; i++) { // target
            int target = prices[i];
            
            int count = 0;
            for(int j = i+1; j < prices.length; j++) {
                count++;
                if(target > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}

/*
입출력 예시를 보면
가격이 떨어지지 않은 기간이 몇 초인지를 return 하도록 하는 함수이기 때문에

prices
[1,2,3,2,3]

target 1
1. 1 -> 2 yes
2. 1 -> 3 yes
3. 1 -> 2 yes
4. 1 -> 3 yes

target 2
1. 2 -> 3 yes
2. 2 -> 2 yes
3. 2 -> 3 yes

target 3
1. 3 -> 2 no

target 4
마지막은 무조건 0
*/