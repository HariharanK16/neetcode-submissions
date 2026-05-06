class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pa = new int[n];
        int[] sa = new int[n];
        for(int i = 0;i<n;i++){
            if(i==0){
                pa[i] = 1;
            }
            else{
                pa[i] = pa[i-1]*nums[i-1];
            }
        }
        for(int i = n-1;i>-1;i--){
            if(i==n-1){
                sa[i] = 1;
            }
            else{
                sa[i] = sa[i+1]*nums[i+1];
            }
        }
        for(int i = 0;i<n;i++){
            nums[i] = pa[i] * sa[i];
        }
        return nums;
    }
}  
