class Solution {
    public int countSubstrings(String s) {
        if(s==null || s==""){
            return 0;
        }
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int count = 0;
        for(int i = n - 1;i>-1;i--){
            for(int j = i;j<n;j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=2 || palindrome[i+1][j-1])){
                    count++;
                    palindrome[i][j] = true;
                }
            }
        }
        return count;
    }
}
