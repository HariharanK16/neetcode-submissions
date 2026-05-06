class Solution {
    Set<List<Integer>> set;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        set = new HashSet<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void dfs(int[] nums, int target, int i, List<Integer> sub){
        if(target == 0){
            set.add(new ArrayList<>(sub));
            return ;
        }
        if(target<=0 || nums.length<=i){
            return ;
        }

        sub.add(nums[i]);
        dfs(nums,target-nums[i],i+1,sub);
        sub.remove(sub.size()-1);
        dfs(nums,target,i+1,sub);
    }
}
