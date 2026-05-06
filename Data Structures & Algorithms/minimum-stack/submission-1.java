class MinStack {
    List<Integer> list;
    List<Integer> preList;
    int ind;
    public MinStack() {
        list = new LinkedList<>();
        preList = new LinkedList<>();
        ind = -1;
    }

    public void push(int val) {
        list.add(val);
        ind++;
        if(preList.isEmpty()){
            preList.add(val);
        } else{
            preList.add(Math.min(val,preList.get(preList.size()-1)));
        }
    }
    
    public void pop() {   
        list.remove(ind);
        preList.remove(ind--);
    }
    
    public int top() {
        return list.get(ind);
    }
    
    public int getMin() {
        return preList.get(ind);
    }
}
