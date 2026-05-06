class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] lm = new int[n];
        int[] rm = new int[n];

        lm[0] = nums[0];
        rm[n-1] = nums[n-1];

        for(int i = 1;i<n;i++){
            if (i % k == 0) {
                lm[i] = nums[i];
            } else {
                lm[i] = Math.max(lm[i - 1], nums[i]);
            }
        }

        for(int i = n-2;i>-1;i--){
            if (i % k == 0) {
                rm[i] = nums[i];
            } else {
                rm[i] = Math.max(rm[i + 1], nums[i]);
            }
        }

        int[] output = new int[n-k+1];

        for(int i = 0 ; i<n-k+1;i++){
            output[i] = Math.max(lm[i+k-1],rm[i]);
        }

        return output;
    }
}
