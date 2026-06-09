public class Solution {
    public String longestPalindrome(String s) {
        int reslen = 0, start = 0;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = n - 1;i>-1;i--){
            for(int j = i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j]= true;
                    if(reslen<j - i + 1){
                        reslen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start+reslen);
    }
}