import java.io.*;
import java.util.*;

class Solution {
    int[] longLen;
    int[] shortLen;
    
    public int solution(int[][] sizes) {
        longLen = new int[sizes.length];
        shortLen = new int[sizes.length];
        
        // 둘 중 긴 변 long에 짧은 변 short에
        int idx = 0;
        for(int[] len: sizes) {
            longLen[idx] = Math.max(len[0], len[1]);
            shortLen[idx] = Math.min(len[0], len[1]);
            idx++;
        }
        
        int maxLong = 0;
        for(int i = 0; i < sizes.length; i++) {
            if(maxLong < longLen[i]) {
                maxLong = longLen[i];
            }
        }
        
        int maxShort = 0;
        for(int i = 0; i < sizes.length; i++) {
            if(maxShort < shortLen[i]) {
                maxShort = shortLen[i];
            }
        }
        
        return maxShort * maxLong;
    }
}
