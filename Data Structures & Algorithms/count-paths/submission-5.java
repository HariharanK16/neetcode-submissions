class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i =0;i<m-1;i++){
            int[] dp2 = new int[n];
            Arrays.fill(dp2, 1);
            for(int j = n-2;j>-1;j--){
                dp2[j] = dp2[j+1] + dp[j];
            }
            dp = dp2;
        }
        return dp[0];
    }
}
