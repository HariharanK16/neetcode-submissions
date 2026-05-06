class Solution {
    public int maxArea(int[] heights) {
        int i = 0, n = heights.length;
        int j = n - 1;

        int res = 0;

        while(i<j){
            int minHeight = Math.min(heights[i],heights[j]);
            res = Math.max(minHeight*(j-i), res);
            if(heights[i]<=heights[j]){
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
