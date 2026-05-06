class Solution {
    List<List<Integer>> set;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        set = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return set;
    }

    private void dfs(int[] nums, int target, int ind, List<Integer> sub){
        if(target == 0){
            set.add(new ArrayList<>(sub));
            return ;
        }
        if(target<0){
            return ;
        }

        for(int i = ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1]){
                continue;
            }
            sub.add(nums[i]);
            dfs(nums,target-nums[i],i+1,sub);
            sub.remove(sub.size()-1);
        }
    }
}
