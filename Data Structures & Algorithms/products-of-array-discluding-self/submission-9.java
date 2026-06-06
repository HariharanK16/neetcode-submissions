class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        res[0] = 1;
        
        for(int i = 1;i<n;i++){
            res[i] = nums[i-1]*res[i-1];
        }
        int prefix = 1;

        for(int i = n-1;i>-1;i--){
            res[i] = res[i] * prefix;
            prefix = prefix * nums[i];
        }
        return res;
    }
}  
