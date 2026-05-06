public class Solution {
    private boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        dp = new boolean[m + 1][n + 1];

        dp[m][n] = true;

        for(int i = m;i>-1;i--){
            for(int j = n;j>-1;j--){
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && dp[i+1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i+j) && dp[i][j+1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}