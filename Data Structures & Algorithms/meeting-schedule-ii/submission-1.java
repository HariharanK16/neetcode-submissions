/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> start = new PriorityQueue<>((a,b)->a-b);
        PriorityQueue<Integer> end = new PriorityQueue<>((a,b)->a-b);
        for(Interval i : intervals){
            start.offer(i.start);
            end.offer(i.end);
        }
        int count = 0;
        int maxCount = 0;
        while(!start.isEmpty()){
            if(start.peek() < end.peek()){
                count++;
                maxCount = Math.max(maxCount,count);
                start.poll();
            }else{
                end.poll();
                count--;
            }
        }
        return maxCount;

    }
}
