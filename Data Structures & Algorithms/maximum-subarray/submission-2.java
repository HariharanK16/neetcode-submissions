class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;

        for(int n: nums){
            curSum+=n;
            max = Math.max(curSum,max);
            if(curSum < 0){
                curSum = 0;
            }
            
        }
        return max;
    }
}
