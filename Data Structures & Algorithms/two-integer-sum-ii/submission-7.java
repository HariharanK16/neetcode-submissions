class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
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
