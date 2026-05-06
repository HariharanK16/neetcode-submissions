class Solution {
    Set<List<Integer>> set;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        set = new HashSet<>();
        List<Integer> sub = new ArrayList<>();
        dfs(candidates, target, 0, sub);

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> list: set){
            res.add(list);
        }
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> sub){
        if(target == 0){
            set.add(new ArrayList<>(sub));
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
