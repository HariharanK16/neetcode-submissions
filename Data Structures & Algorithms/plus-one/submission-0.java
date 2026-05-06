class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        Stack<Integer> res = new Stack<>();
        int carry = 1;
        for(int i = n-1;i>-1;i--){
            int val = (digits[i]+carry)%10;
            carry = (digits[i]+carry)/10;
            res.push(val);
        }
        if(carry>0){
            res.push(carry);
        }
        int result[] = new int[res.size()];
        int i = 0;
        while(!res.isEmpty()){
            result[i++] = res.pop(); 
        }
        return result;
    }
}
