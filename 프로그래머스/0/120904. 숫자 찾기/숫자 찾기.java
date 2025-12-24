import java.io.*;
import java.util.*;

class Solution {
    public int solution(int num, int k) {
        String numStr = Integer.toString(num);
        char[] charStr = numStr.toCharArray();
        
        for(int i = 0; i < numStr.length(); i++) {
            if(charStr[i] - '0' == k) return i+1;
        }
        return -1;
    }
}