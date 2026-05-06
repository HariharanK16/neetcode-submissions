class Solution {
    public int rob(int[] nums) {
        int prevMax = 0, currMax = 0;

        for(int num:nums){
            int t = currMax;

            currMax = Math.max(prevMax+num,currMax);
            prevMax = t;
        }
        return currMax;
    }
}
