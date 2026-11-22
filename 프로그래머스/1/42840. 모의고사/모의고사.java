import java.io.*;
import java.util.*;

class Solution {
    int[][] students = {
        {1, 2, 3, 4, 5}, // 5주기
        {2, 1, 2, 3, 2, 4, 2, 5}, // 8주기
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 10주기
    };
    
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        
        int answerLen = answers.length;
        
        int maxCount=0;
        for(int i = 0; i< 3; i++) {
            int count = 0;
            for(int j = 0; j < answers.length; j++) {
                if(answers[j]==students[i][j%(students[i].length)]) {
                    count++;
                }
            }
            score[i] = count;
            maxCount = Math.max(maxCount, count);
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int idx = 0; idx < score.length; idx++) {
            if(score[idx]==maxCount) {
                answer.add(idx+1);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}

/*
3개에 각각 맞은 것 기록
[1,2,3,4,5]
[5, 0, 0] >> [1]

[1,3,2,4,2]
[2, 2, 2] >> [1,2,3]

5번째 인덱스는 다시 0으로 돌아가게
0일 때 0
1일 때 1
2일때 2
3일때 3
4일때 4
5일때 0

(idx)%전체길이
*/