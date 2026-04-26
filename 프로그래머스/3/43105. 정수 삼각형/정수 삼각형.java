class Solution {
    public int solution(int[][] triangle) {
        int dp[][] = new int[triangle.length][];
        for(int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle.length];
        }
        
        dp[0][0] = triangle[0][0];
        
        for(int r = 1; r < triangle.length; r++) {
            dp[r][0] = dp[r-1][0] + triangle[r][0];
            dp[r][r] = dp[r-1][r-1] + triangle[r][r];
            
            for(int i = 1; i < r; i++) {
                dp[r][i] = Math.max(dp[r-1][i-1] + triangle[r][i], dp[r-1][i] + triangle[r][i]);
            }
        }
        
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < dp[triangle.length-1].length; i++) {
            if(maxValue < dp[triangle.length-1][i]) {
                maxValue = dp[triangle.length-1][i];
            }
        }
        return maxValue;
    }
}