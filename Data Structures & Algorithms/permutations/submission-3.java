class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {

        res= new ArrayList<>();

        dfs(nums, new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                dfs(nums,list);
                list.remove(list.size()-1);
            }
        }

    }
}
