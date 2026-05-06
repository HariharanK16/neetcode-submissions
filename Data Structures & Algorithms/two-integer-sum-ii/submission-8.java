class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j = nums.length-1;
        while(i<j){
            while(i<j && nums[i]+nums[j]>target){
                j--;
            }
            while(i<j && nums[i]+nums[j]<target){
                i++;
            }
            if(nums[i]+nums[j]==target){
                break;
            }
        }
        return new int[]{i+1,j+1};
    }
}
