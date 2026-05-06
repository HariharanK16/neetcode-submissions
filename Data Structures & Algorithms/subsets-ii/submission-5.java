class Solution {
    List<List<Integer>> set = new ArrayList<>();;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        bt(nums, 0,  new ArrayList<>());
        return set;
    }

    private void bt(int[] nums, int ind, List<Integer> list){
        set.add(new ArrayList<>(list));
        for(int i = ind;i<nums.length;i++){
            if(i>ind && nums[i] == nums[i-1]) continue;
                list.add(nums[i]);
                bt(nums,i+1,list);
                list.remove(list.size()-1);
        }
    }
}
