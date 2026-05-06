class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int n = og.length, m = og[0].length;
        if (og[0][0] == 1 || og[n-1][m-1] == 1) {
            return 0;
        }
        int[][] dp = new int[n+1][m+1];
        dp[n-1][m-1] = 1;
        
        for(int i = n-1;i>-1;i--){
            for(int j = m-1;j>-1;j--){
                if(og[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] += dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}