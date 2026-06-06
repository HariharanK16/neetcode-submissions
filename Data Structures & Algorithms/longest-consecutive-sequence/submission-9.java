class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int num:nums)unique.add(num);

        int max= 0;
        for(int num:unique){
            if(!unique.contains(num-1)){
                int start = num;
                int currMax = 0;
                while(unique.contains(start)){
                    currMax++;
                    start++;
                }
                max= Math.max(currMax,max);

            }
        }
        return max;
    }
}
