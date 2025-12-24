import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        // 1부터 n까지 나눠보면서 되면 넣기
        for(int i = 1; i<=n; i++) {
            if(n%i==0)
            {
                answer.add(i);
            }
        }
        
        int[] answerArray = answer.stream().mapToInt(i->i).toArray();
        
        return answerArray;
    }
}