class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lm = new int[n];
        int[] rm = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            lm[i] = -1;
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(!stack.empty()){
                lm[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for(int i = n-1;i>-1;i--){
            rm[i] = n;
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(!stack.empty()){
                rm[i] = stack.peek();
            }

            stack.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i<n ;i++){
            maxArea = Math.max(maxArea, heights[i]*((--rm[i])-(++lm[i])+1));
        }
        return maxArea;
    }
}
