class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(nums,target,sub,0);
        return res;
    }

    private void dfs(int[] nums, int target,  List<Integer> sub, int i){
        if(0 == target){
            res.add(new ArrayList<>(sub));
            return;
        }
        if(target < 0 || i >= nums.length){
            return;
        }
        

        sub.add(nums[i]);
        dfs(nums,target-nums[i],sub,i);
        sub.remove(sub.size()-1);
        dfs(nums,target,sub,i+1);

    }
}
