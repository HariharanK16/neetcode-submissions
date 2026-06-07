class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> stack = new Stack();
        int[] output = new int[temp.length];

        int i = 0;
        for(int t:temp){
            while(!stack.isEmpty() && stack.peek()[0]<t){
                int[] val = stack.pop();
                output[val[1]] = i - val[1];
            }
            stack.push(new int[]{t,i});
            i++;
        }
        return output;
    }
}
