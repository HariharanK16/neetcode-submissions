class MinStack {
    Stack<Integer> list;
    Stack<Integer> preList;
    public MinStack() {
        list = new Stack<>();
        preList = new Stack<>();
    }

    public void push(int val) {
        list.push(val);
        if(preList.isEmpty()){
            preList.push(val);
        } else{
            preList.push(Math.min(val,preList.peek()));
        }
    }
    
    public void pop() {   
        list.pop();
        preList.pop();
    }
    
    public int top() {
        return list.peek();
    }
    
    public int getMin() {
        return preList.peek();
    }
}
