class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();

        int n = position.length;

        for(int i = 0;i<n;i++){
            list.add(new int[]{position[i],speed[i]});
        }

        Collections.sort(list,(a,b)->b[0]-a[0]);

        Stack<Float> stack = new Stack();

        for(int[] val:list){
            float dist = (float)(target - val[0]) / val[1];
            if(stack.isEmpty() || stack.peek() < dist){
                stack.add(dist);
            }
        }
        return stack.size();
    }
}
