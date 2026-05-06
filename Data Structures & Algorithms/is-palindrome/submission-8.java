class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int i = 0, j =n-1;
        while(i<=j){
            char low = Character.toLowerCase(s.charAt(i));
            char high = Character.toLowerCase(s.charAt(j));

            if(!Character.isLetterOrDigit(low)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(high)){
                j--;
                continue;
            }

            if(low != high){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
