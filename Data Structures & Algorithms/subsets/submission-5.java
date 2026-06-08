class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        bt(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void bt(List<List<Integer>> res , List<Integer> sub, int ind, int[] nums){
        res.add(new ArrayList(sub));

        for(int i = ind;i<nums.length;i++){
            sub.add(nums[i]);
            bt(res,sub,i+1,nums);
            sub.removeLast();
        }
    }
}
