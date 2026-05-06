class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack();
        int n = heights.length;

        for(int i = 0;i<n;i++){
            int leftBound = i;

            while(!stack.isEmpty() && stack.peek()[0] >= heights[i]){
                int[] val = stack.pop();
                int h = val[0];
                int ind = val[1];
                maxArea = Math.max(maxArea, h*(i-ind));
                leftBound = ind;
            }
            stack.push(new int[]{heights[i],leftBound});
        }

        while(!stack.isEmpty()){
            int[] val = stack.pop();
            int h = val[0];
            int ind = val[1];
            maxArea = Math.max(maxArea, h*(n-ind));
        }
        return maxArea;
    }
}
