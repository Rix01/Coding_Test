import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] people, int limit) {        
        int answer = 0;
        // 정렬
        Arrays.sort(people);
        
        int maxIndex = people.length -1;
        int minIndex = 0;
        
        while(minIndex <= maxIndex) {
            if(people[minIndex] + people[maxIndex] <= limit) {
                answer += 1;
                maxIndex--;
                minIndex++;
            }
            
            else {
                answer += 1;
                maxIndex--;
            }
        }
        return answer;
    }
}

/**
최대 2명
limit

50 50 70 80
1. 50 + 80 = 130
2. 50 + 70 = 120
3. 50 + 50 = 100

**/