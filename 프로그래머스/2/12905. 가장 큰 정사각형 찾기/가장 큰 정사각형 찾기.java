import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length; // 행
        int m = board[0].length; // 열
        int dp[][] = new int[n + 1][m + 1]; // dp 저장 배열
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = board[i][j];
            }
        } 
        
        int answer = 0;
        // 순차적으로 돌면서
        for(int r = 1; r <= n; r++){
            for(int c = 1; c <= m; c++) {
                if(dp[r][c] == 0){ // 0일 때는 스킵
                    continue;
                }
                
                dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1; // 셋 중 최솟값 구하기
                answer = Math.max(dp[r][c], answer); // 최고값 갱신
            }
        }
        return answer * answer;
    }
}
