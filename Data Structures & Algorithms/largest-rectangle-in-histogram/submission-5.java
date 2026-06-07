class Solution {
    public int largestRectangleArea(int[] hts) {
        Stack<int[]> stack = new Stack<>();

        int n = hts.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[0] > hts[i]) {
                int[] val = stack.pop();

                int currMax = (i - val[1]) * val[0];
                max = Math.max(max,currMax);
                start = val[1];
            }
            stack.push(new int[]{hts[i],start});
        }

        while(!stack.isEmpty()) {
            int[] val = stack.pop();
            int currMax = (n - val[1]) * val[0];
            max = Math.max(max,currMax);
        }
        return max;
    }
}
