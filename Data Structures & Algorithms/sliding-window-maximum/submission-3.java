class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int lm[] = new int[n];
        int rm[] = new int[n];

        // lm[0] = nums[0];
        // rm[n-1] = nums[n-1];
        int max = 0;
        for(int i = 0;i<n;i++){
            if(i%k == 0){
                max = nums[i];                
            }else{
                max = Math.max(max,nums[i]);
            }
            lm[i] = max;
        }
        max = 0;
        for(int i = n-1;i>-1;i--){
            if(i%k == 0){
                max = nums[i];                
            }else{
                max = Math.max(max,nums[i]);
            }
            rm[i] = max;
        }

        int[] res = new int[n-k+1];

        for(int i = 0;i<n-k+1;i++){
            res[i] = Math.max(lm[i+k-1],rm[i]);
        }
        return res;
    }
}
