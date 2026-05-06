class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        int n = position.length;
        for(int i = 0 ;i<n;i++){
            list.add(new int[]{position[i],speed[i]});
        }
        list.sort((a,b)->a[0]-b[0]);

        Stack<Float> stack = new Stack<>();
        float max = (float)Integer.MIN_VALUE;
        int count = 0;
        for(int i = n-1;i>-1;i--){
            float time = (float)(target - list.get(i)[0]) / (float)list.get(i)[1];
            if(max<time){
                count++;
                max = time;
                // stack.push(time);
            }
        }
        return count;
    }
}
