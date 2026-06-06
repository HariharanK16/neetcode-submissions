class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxWater = 0;
        while(left<right){
            int minWater = Math.min(heights[left],heights[right]);
            maxWater = Math.max(maxWater,minWater*(right - left));
            if(heights[left] == minWater) left++; else right--;
        }
        return maxWater;
    }
}
