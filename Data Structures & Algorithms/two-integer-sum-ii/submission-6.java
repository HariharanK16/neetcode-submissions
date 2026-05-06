class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = 1;
        while(i<n){
            if(j==n){
                i++;
                j = i+1;
                continue;
            }
            System.out.println("i->"+nums[i]);
            System.out.println("j->"+nums[j]);
            if((nums[i]+nums[j])<target){j++;continue;}
            if((nums[i]+nums[j])>target){                i++;
                j = i+1;
                continue;}
            if(nums[i]+nums[j]==target){
                break;
            }
        }
        return new int[]{i+1,j+1};
    }
}
