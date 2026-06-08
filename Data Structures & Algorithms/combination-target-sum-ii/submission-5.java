class Solution {
    List<List<Integer>> set;
    public List<List<Integer>> combinationSum2(int[] nums, int t) {
        Arrays.sort(nums);
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
            if(i>ind && nums[i] == nums[i-1]) continue;
            sub.add(nums[i]);
            backTracking(nums,t-nums[i],res,sub,i+1);
            sub.removeLast();
        }
    }
}
