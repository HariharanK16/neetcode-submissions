class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {

        res= new ArrayList<>();

        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    private void dfs(int[] nums, List<Integer> list, boolean[] view){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i<nums.length;i++){
            if(!view[i]){
                list.add(nums[i]);
                view[i] = true;
                dfs(nums,list,view);
                list.remove(list.size()-1);
                view[i]=false;
            }
        }

    }
}
