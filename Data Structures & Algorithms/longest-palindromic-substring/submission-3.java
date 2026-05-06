class Solution {
    int ind = 0, resLen = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            checkPanlindrome(s,i,i);
            checkPanlindrome(s,i,i+1);
        }

        return s.substring(ind,ind+resLen);
    }

    public void checkPanlindrome(String s, int l, int r){
        while(l>-1 && r<s.length() && s.charAt(l) == s.charAt(r)){
            if(r-l+1 > resLen){
                resLen = r-l+1;
                ind = l;
            }
            l--;
            r++;
        }
    }
}