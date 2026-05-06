class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> sub){
        if(i==nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        dfs(nums,i+1,sub);
        sub.remove(sub.size()-1);
        dfs(nums,i+1,sub);
    }
}
