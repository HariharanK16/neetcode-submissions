class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        int[][] list = new int[n][2];
        for(int i = 0 ;i<n;i++){
            list[i] = new int[]{position[i],speed[i]};
        }
        Arrays.sort(list,(a,b)->a[0]-b[0]);

        float max = (float)Integer.MIN_VALUE;
        int count = 0;
        for(int i = n-1;i>-1;i--){
            float time = (float)(target - list[i][0]) / (float)list[i][1];
            if(max<time){
                count++;
                max = time;
            }
        }
        return count;
    }
}
