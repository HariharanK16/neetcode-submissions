class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;
    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b)->b-a);
        largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.add(num);

        if(smallHeap.size() - largeHeap.size()>1 || !largeHeap.isEmpty() && largeHeap.peek()<smallHeap.peek()){
            largeHeap.offer(smallHeap.poll());
        }

        if(smallHeap.size() - largeHeap.size()<-1){
            smallHeap.offer(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size()==largeHeap.size()){
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2.0;
        }else if(smallHeap.size()<largeHeap.size()){
            return largeHeap.peek();
        }else{
            return smallHeap.peek();
        }
    }
}
