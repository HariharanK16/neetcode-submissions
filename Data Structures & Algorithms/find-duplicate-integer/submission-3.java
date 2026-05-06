class Solution {
    public int findDuplicate(int[] nums) {
        for(int num : nums){
            int i = Math.abs(num);

            if(nums[i]<0) return Math.abs(num);

            nums[i] *= -1;
        }
        return -1;
    }
}
