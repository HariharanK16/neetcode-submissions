class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];

        int min = 1, max = 1;

        for(int num:nums){
            int t = num*max;
            max = Math.max(Math.max(num*max,num*min),num);
            min = Math.min(Math.min(t,num*min),num);
            res = Math.max(res,max);
        }
        return res;
    }
}
