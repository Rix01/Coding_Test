import java.io.*;
import java.util.*;

class Solution {
    public long[] dp = new long[2001];
    
    public long solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        
        // 일단 배열 만들기
        for(int i = 3; i <= 2000; i ++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        return dp[n];
    }
}