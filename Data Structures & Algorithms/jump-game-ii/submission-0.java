class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0, r= 0;
        int res  = 0;
        while(r<n-1){
            int farther = 0;
            for(int i = l;i<=r;i++){
                farther = Math.max(farther,i+nums[i]);
            }
            l = r + 1;
            r = farther;
            res++;
        }
        return res;
    }
}
