class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int a = 0,b = 1;
        for(int i = 0; i < n-1 ; i++){
            for(int j = i+1; j<n; j++) {
                if(target == nums[i]+nums[j]){
                    a = i;
                    b = j;
                }
            }
        }
        return new int[]{a,b};
    }
}
