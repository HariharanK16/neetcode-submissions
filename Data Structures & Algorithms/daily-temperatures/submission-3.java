class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        if(n==0){
            return new int[]{};
        }
        int res[] = new int[n];
        Stack<int[]> stack = new Stack<>();
        int i = 0;
        for(int t:temp){
            while(!stack.isEmpty() && t>stack.peek()[0]){
                int[] val = stack.pop();
                res[val[1]] = i - val[1];
            }
            stack.push(new int[]{t,i});
            i++;
        }
        return res;
    }
}
