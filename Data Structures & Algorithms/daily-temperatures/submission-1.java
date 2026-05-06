class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        Stack<int[]> s = new Stack<>();

        int res[] =  new int[n];
        for(int i = 0;i<n;i++){
            int temp = t[i];
            while(!s.isEmpty() && temp > s.peek()[0]){
                int[] val = s.pop();
                res[val[1]] = i-val[1];
            }
            s.push(new int[]{temp,i});
        }
        return res;
    }
}
