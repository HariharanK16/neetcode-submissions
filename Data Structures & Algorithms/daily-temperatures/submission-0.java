class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Pair<Integer,Integer>> s = new Stack<>();
        int n = temp.length;
        int res[] = new int[n];
        for(int i = 0;i<n;i++){
            while(!s.isEmpty() && s.peek().getKey()<temp[i] ){
                        System.out.println(s);
                int ind = s.pop().getValue();
                res[ind]=i-ind;
            }
            s.add(new Pair<Integer,Integer>(temp[i],i));
        }
return res;
    }
}
