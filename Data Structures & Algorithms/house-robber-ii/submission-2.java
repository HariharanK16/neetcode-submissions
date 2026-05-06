class Solution {
    public int rob(int[] nums) {
      if (nums.length == 1) return nums[0];  
      return Math.max(helper(nums,0, nums.length-1), helper(nums,1, nums.length));
    }
    
    public int helper(int[] nums, int start, int end){
      int preMax = 0, curMax = 0;
      for(int i = start; i < end; i++){
        int t = curMax;
        curMax = Math.max(preMax + nums[i], curMax);
        preMax = t;  
      }  
      return curMax;
    }
}