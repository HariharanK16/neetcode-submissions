class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        bt(new ArrayList(), nums, 0);
        return res;
    }

    private void bt(List<Integer> sub, int[] nums, int ind){
        if(ind == nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(sub.contains(nums[i])) continue;
            sub.add(nums[i]);
            bt(sub,nums,ind+1);
            sub.removeLast();
        }
    }
}
