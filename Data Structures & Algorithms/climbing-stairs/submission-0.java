class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int dp = 0, dp1 = 2, dp2 = 1;
        for(int i = 3;i<=n;i++){
            dp = dp1 + dp2;
            dp2 = dp1;
            dp1 = dp;
        }
        return dp;
    }
}
