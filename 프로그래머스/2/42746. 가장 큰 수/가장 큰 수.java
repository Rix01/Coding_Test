import java.io.*;
import java.util.*;

class Solution {
    
    
    public String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numStrs, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        
        if(numStrs[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str:numStrs) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}