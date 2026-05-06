class Solution {
    int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        if(n==0) return 0;
        if(n==1) return nums[0];

        return dfs(nums,0);
    }
    public int dfs(int[] nums, int ind){
        if(ind >= nums.length){
            return 0;
        }

        if(memo[ind]!=-1){
            return memo[ind];
        }

        memo[ind] = Math.max(nums[ind] + dfs(nums,ind+2), dfs(nums,ind+1));
        return memo[ind];
    }
}
