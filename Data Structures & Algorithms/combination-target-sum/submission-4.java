class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int t) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(nums,t,res,new ArrayList<>(),0);
        return res;
    }

    private void backTracking(int[] nums, int t, List<List<Integer>> res, List<Integer> sub, int ind) {
        if(t == 0){
            res.add(new ArrayList(sub));
            return;
        }
        if(t<0){
            return;
        }

        for(int i = ind;i<nums.length;i++){
            sub.add(nums[i]);
            backTracking(nums,t-nums[i],res,sub,i);
            sub.removeLast();
        }
    }
}
