class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] lm = new int[n];
        int[] rm = new int[n];

        lm[0] = height[0];
        rm[n-1] = height[n-1];
        for(int i = 1 ;i<n;i++){
            lm[i] = Math.max(height[i],lm[i-1]);
            rm[n-i-1] = Math.max(height[n-i-1],rm[n-i]);
        }

        int water = 0;

        for(int i = 0;i<n;i++){
            water+=Math.min(lm[i],rm[i])-height[i];
        }
        return water;
    }
}
