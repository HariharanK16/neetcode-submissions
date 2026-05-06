class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int a = 0, b=1;
        for(int i = 0;i<nums.length;i++){
            int val = map.getOrDefault(target-nums[i],Integer.MIN_VALUE);
            if(val!=Integer.MIN_VALUE && val != i){
                return new int[]{val,i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
