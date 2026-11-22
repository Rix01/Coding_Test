import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] cits = new Integer[citations.length];
        for(int i = 0; i < cits.length; i++) {
            cits[i] = citations[i];
        }
        
        Arrays.sort(cits, Collections.reverseOrder());
        
        int answer = 0;
        for(int i = 0; i < cits.length; i++) {
            if(cits[i] >= i+1) {
                answer = i+1;
            }
            else {
                break;
            }
        }
        return answer;
    }
}