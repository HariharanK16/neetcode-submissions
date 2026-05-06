class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 1;
        for(int s : set){
            if(set.contains(s+1)){
                int i = s+1;
                int count = 1;
                while(set.contains(i)){
                    count++;
                    i++;
                }
                if(max<count){
                    max = count;
                }
            }
        }
        return max;
    }
}
