class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums,res, new ArrayList(), 0);
        return res;

    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> sub, int ind){
        res.add(new ArrayList<>(sub));

        for(int i = ind;i<nums.length;i++){
            sub.add(nums[i]);
            backtrack(nums,res, sub, i+1);
            sub.removeLast();
        }
    }
}
