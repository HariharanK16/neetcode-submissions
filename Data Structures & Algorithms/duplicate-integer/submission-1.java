class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            int val = map.getOrDefault(num,0);
            if(val>0){
                return true;
            }
            map.put(num,1);
        }
        return false;
    }
}
