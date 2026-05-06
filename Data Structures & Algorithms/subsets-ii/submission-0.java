class Solution {
    Set<List<Integer>> set;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        set = new HashSet<>();
        bt(nums, 0,  new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void bt(int[] nums, int i, List<Integer> list){
        if(nums.length == i){
            set.add(new ArrayList<>(list));
            return ;
        }

        list.add(nums[i]);
        bt(nums,i+1,list);
        list.remove(list.size()-1);
        bt(nums,i+1,list);
    }
}
