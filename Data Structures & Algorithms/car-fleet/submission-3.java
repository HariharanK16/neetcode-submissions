class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        int n = position.length;
        for(int i = 0 ;i<n;i++){
            list.add(new int[]{position[i],speed[i]});
        }
        list.sort((a,b)->a[0]-b[0]);

        Stack<Float> stack = new Stack<>();
        for(int i = n-1;i>-1;i--){
            float time = (float)(target - list.get(i)[0]) / (float)list.get(i)[1];
            System.out.println(time);
            if(stack.isEmpty() || stack.peek()<time){

                stack.push(time);
            }
        }
        return stack.size();
    }
}
