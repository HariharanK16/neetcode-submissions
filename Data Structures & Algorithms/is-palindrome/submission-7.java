class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int i = 0, j =n-1;
        while(i<=j){
            char low = Character.toLowerCase(s.charAt(i));
            char high = Character.toLowerCase(s.charAt(j));

            if(Math.abs(low-'a')>25 && !Character.isDigit(low)){
                i++;
                continue;
            }
            if(Math.abs(high-'a')>25 && !Character.isDigit(high)){
                j--;
                continue;
            }
            System.out.println("i=>"+Math.abs(low-'a'));
            System.out.println("j=>"+Math.abs(high-'a'));
            if(low != high){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
