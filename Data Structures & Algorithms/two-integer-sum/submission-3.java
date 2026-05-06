class Solution {
    public int getKey(HashMap<Integer,Integer> map, int value){
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue().intValue() == value){
                return entry.getKey().intValue();
            }
        }
        return 0;
    }
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int a = 0,b = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n ; i++){
            if(map.containsValue(target-nums[i])){
                b = getKey(map,target-nums[i]);
                a = i;
            }else{
                map.put(i,nums[i]);
            }

        }
        return new int[]{b,a};
    }
}
