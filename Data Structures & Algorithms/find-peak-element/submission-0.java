class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;

        while(l<=r){
            int m = l + (r - l) / 2;
            if(m+1<nums.length && nums[m]<nums[m+1]){
                l = m + 1;
            }else if(m-1>=0 && nums[m]<nums[m-1]){
                r = m - 1;
            }else{
                return m;
            }
        }
        return 0;
    }
}