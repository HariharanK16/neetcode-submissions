class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null){
            return 0;
        }

        if(text1.length() < text2.length()){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[] dp = new int[text2.length()+1];

        for(int i = text1.length()-1;i>-1;i--){
            int[] dp1 = new int[text2.length()+1];
            for(int j = text2.length()-1;j>-1;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp1[j] = 1 + dp[j+1];
                }else{
                    dp1[j] = Math.max(dp1[j+1], dp[j]);
                }
            }
            dp = dp1;
        }
        return dp[0];
    }
}
