import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int[] bigs = new int[sizes.length];
        int[] smalls = new int[sizes.length];
        
        int idx = 0;
        for(int[] size:sizes) {
            if(size[0] >= size[1]) {
                bigs[idx] = size[0];
                smalls[idx] = size[1];
            } else {
                bigs[idx] = size[1];
                smalls[idx] = size[0];
            }
            idx++;
        }
        
        Arrays.sort(bigs);
        Arrays.sort(smalls);

        return bigs[sizes.length - 1] * smalls[sizes.length - 1];
    }
}

/*
큰 값을 앞에다!
1. 60 50
2. 70 30
3. 60 30
4. 80 40
>> 80 50
*/