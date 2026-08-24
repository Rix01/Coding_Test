import java.io.*;
import java.util.*;

class Solution {
    String[] available = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int count = 0;
        
        for(String word: babbling) {
            if(checkWord(word)) {
                count++;
            }
        }
        
        return count;
    }
    
    public boolean checkWord(String word) {
        String beforeWord = ""; // 맨 처음에는 빈 단어
        
        while(!word.isEmpty()) {
            boolean found = false;
            
            // available 돌면서
            for(String avail: available) {
                // avail로 시작하면 킵 고잉
                if(word.startsWith(avail)) {
                    // 2번 이상 중복이면
                    if(beforeWord.equals(avail)) {
                        return false;
                    }
                    
                    beforeWord = avail;
                    
                    word = word.substring(avail.length());
                    
                    found = true;
                    break;
                }
            }
            
            if(!found) {
                return false;
            }
        }
        return true;
    }
}