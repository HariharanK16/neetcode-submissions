class Solution {
    public int leastInterval(char[] tasks, int n) {
        int counts[] = new int[26];
        for(char task:tasks){
            counts[task-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int count:counts){
            if(count>0) pq.offer(count);
        }
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(pq.isEmpty()){
                time = queue.peek()[1];
            }else{
                int val = pq.poll();
                if(val-1>0){
                    queue.add(new int[]{val-1, time+n});
                }
            }

            while(!queue.isEmpty() && time == queue.peek()[1]){
                pq.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
