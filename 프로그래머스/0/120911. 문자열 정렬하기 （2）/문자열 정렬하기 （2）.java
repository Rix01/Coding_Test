import java.io.*;
import java.util.*;

class Solution {
    public String solution(String my_string) {
        String lowerString = my_string.toLowerCase();
        char[] lowerArray = lowerString.toCharArray();
        
        Arrays.sort(lowerArray);
        
        return String.valueOf(lowerArray);
    }
}