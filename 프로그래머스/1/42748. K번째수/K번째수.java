import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int answerIdx = 0;
        for(int[] command:commands) {
            int startIdx = command[0] - 1;
            int endIdx = command[1] - 1;
            int targetIdx = command[2] - 1;
            int[] newArray = new int[endIdx - startIdx + 1];
            int idx = 0;
            for(int i = startIdx; i <= endIdx; i++) {
                newArray[idx] = array[i];
                idx++;
            }
            Arrays.sort(newArray);
            answer[answerIdx] = newArray[targetIdx];
            answerIdx++;
        }
        return answer;
    }
}