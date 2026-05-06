class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int[] map = new int[26];
        for(char task: tasks){
            map[task-'A']++;
        }

        for(int i:map){
            if(i>0)
                pq.offer(i);
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(pq.isEmpty()){
                time=q.peek()[1];
            } else {
                int val = pq.poll();
                if(val-1 > 0)
                    q.add(new int[]{val-1,time+n});
                
            }
            
            if(!q.isEmpty() && q.peek()[1]==time){
                    pq.offer(q.poll()[0]);
                }
        }

        return time;
    }
}
