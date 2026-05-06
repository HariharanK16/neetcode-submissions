class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        int i = 0;
        for(int height:heights){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[0]>height){
                int[] val = stack.pop();
                int index = val[1];
                int h = val[0];
                maxArea = Math.max(maxArea, h*(i-index));
                start = index;
            }
            stack.push(new int[]{height,start});
            i++;
        }
        for(int[] pair:stack){
            i = pair[1];
            int h = pair[0];
            maxArea = Math.max(maxArea, (heights.length - i) * h);
        }
        return maxArea;
    }
}
