class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean duplicate = false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num:nums){
            if(map.get(num)!=null){
                duplicate = true;
                break;
            } else{
                map.put(num,1);
            }
        }
        return duplicate;
    }
}
