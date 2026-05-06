class Solution {
    List<List<Integer>> res  = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) { 
        dfs(nums,target,0);
        return res;
    }

    private void dfs(int[] nums, int target, int ind){
        if(0 == target){
            res.add(new ArrayList<>(sub));
            return;
        }
        if(target < 0 || ind == nums.length){
            return;
        }
        
        for(int i = ind;i<nums.length;i++){
            sub.add(nums[i]);
            dfs(nums,target-nums[i],i);
            sub.remove(sub.size()-1);
        }
    }
}
