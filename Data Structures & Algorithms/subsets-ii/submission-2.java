class Solution {
    List<List<Integer>> set = new ArrayList<>();;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        bt(nums, 0,  new ArrayList<>());
        return set;
    }

    private void bt(int[] nums, int i, List<Integer> list){
        if(nums.length == i){
            set.add(new ArrayList<>(list));
            return ;
        }

        list.add(nums[i]);
        bt(nums,i+1,list);
        list.remove(list.size()-1);
        i++;
        while(i<nums.length && nums[i]==nums[i-1]){
            i++;
        }
        bt(nums,i,list);
    }
}
