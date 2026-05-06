class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;

        Stack<int[]> stack = new Stack();
        int[] daily = new int[n];
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()[0] < temp[i]){
                int[] t = stack.pop();
                daily[t[1]] = i - t[1];
            }
            stack.push(new int[]{temp[i],i});
        }
        return daily;
    }
}
