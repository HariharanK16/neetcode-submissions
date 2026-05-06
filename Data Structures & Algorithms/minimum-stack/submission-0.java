class MinStack {
    // int min;
    LinkedList<Integer> list;
    int ind;
    public MinStack() {
        // min = Integer.MAX_VALUE;
        list = new LinkedList<>();
        ind = 0;
    }
    
    // public void setMin(int val){
    //     if(min>val){
    //         min = val;
    //     }
    // }
    public void push(int val) {
        // setMin(val);
        list.add(val);
        ind++;
    }
    
    public void pop() {

        list.remove(--ind);
    }
    
    public int top() {
        return list.get(ind-1);
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int val : list){
            min = Math.min(min,val);
        }
        return min;
    }
}
