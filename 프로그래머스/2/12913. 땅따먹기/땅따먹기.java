import java.io.*;
import java.util.*;

class Solution {
    int solution(int[][] land) {
        int row = land.length;
        
        for(int r = 1; r < row; r++) {
            for(int c = 0; c < 4; c++) {
                int maxValue = 0;
                for(int k = 0; k < 4; k++) {
                    if(c==k) continue;
                    maxValue = Math.max(maxValue, land[r-1][k]);
                }
                land[r][c] += maxValue;
            }
        }
        
        int result = 0;
        for(int i = 0; i < 4; i++) {
            if(land[row-1][i] > result) {
                result = land[row-1][i];
            }
        }

        return result;
    }
}