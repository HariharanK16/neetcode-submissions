class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        int  n = position.length;
        for(int i = 0 ; i < n ; i++){
            list.add(new int[]{position[i],speed[i]});
        }
        Collections.sort(list,(a,b)->a[0]-b[0]);

        float max = Float.MIN_VALUE;
        Stack<Float> stack = new Stack();
        for(int i = list.size()-1;i>-1;i--){
            float time = (float)(target-list.get(i)[0])/(float) list.get(i)[1];
            if(stack.isEmpty() || time>stack.peek()){
            
                stack.push(time);
            }
        }
        return stack.size();
    }
}
