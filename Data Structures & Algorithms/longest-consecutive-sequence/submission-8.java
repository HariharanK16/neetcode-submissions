class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 0;
        for(int s : set){
            if(!set.contains(s-1)){
                int i = 1;
                while(set.contains(s+i)){
                    i++;
                }
                if(max<i){
                    max = i;
                }
            }
        }
        return max;
    }
}
