class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int lm[] = new int[n];
        int rm[] = new int[n];

        lm[0] = nums[0];
        rm[n-1] = nums[n-1];
        for(int i = 1;i<n;i++){
            if(i%k==0){
                lm[i] = nums[i];
            }else{
                lm[i] = Math.max(lm[i-1],nums[i]);
            }

            if((n-i-1)%k == 0){
                rm[n-i-1] = nums[n - i -1];
            }else {
                rm[n-i-1] = Math.max(rm[n-i],nums[n-i-1]);
            }
        }

        int res[] = new int[n-k+1];
        for(int i = 0 ;i<n-k+1;i++){
            res[i] = Math.max(rm[i],lm[i+k-1]);
        }
        return res;
    }
}
