class Solution {
    String res = "";
    public String longestPalindrome(String s) {
        int resLen = 0, resIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            checkPanlindrome(s,i,i);
            checkPanlindrome(s,i,i+1);
        }

        return res;
    }

    public void checkPanlindrome(String s, int l, int r){
        while(l>-1 && r<s.length() && s.charAt(l) == s.charAt(r)){
            if(r-l+1 > res.length()){
                res = s.substring(l, r+1);
            }
            l--;
            r++;
        }
    }
}