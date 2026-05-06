class Solution {
    public String multiply(String num1, String num2) {
        long n1 = 0, n2 = 0;

        int n = num1.length();
        for(int i = 0;i<n;i++){
            n1 = (n1 * 10)+(num1.charAt(i)-'0');
        }

        int m = num2.length();
        for(int i = 0;i<m;i++){
            n2 = (n2 * 10)+(num2.charAt(i)-'0');
        }
        return  Long.toString(n1*n2);
    }
}
