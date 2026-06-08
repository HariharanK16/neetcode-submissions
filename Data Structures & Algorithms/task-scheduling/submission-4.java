class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(int task:tasks){
            count[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        Queue<int[]> queue = new LinkedList<>();

        for(int c:count){
            if(c!=0) pq.add(c);
        }

        int tt = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            tt++;
            if(pq.isEmpty()){
                tt = queue.peek()[1];
            }
            else{
                int val = pq.poll();
                if(val - 1 > 0){
                    queue.add(new int[]{val-1,tt+n});
                }
                
            }
            while(!queue.isEmpty() && queue.peek()[1]==tt){
                pq.offer(queue.poll()[0]);
            }
        }
        return tt;
    }
}
