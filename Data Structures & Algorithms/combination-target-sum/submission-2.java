class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,0,target,new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums, int ind, int target, List<Integer> sum){
        if(target == 0){
            res.add(new ArrayList<>(sum));
        }
        if(target<0){
            return;
        }
        for(int i = ind;i<nums.length;i++){
            sum.add(nums[i]);
            dfs(nums,i, target-nums[i],sum);
            sum.remove(sum.size()-1);
        }
    }
}
