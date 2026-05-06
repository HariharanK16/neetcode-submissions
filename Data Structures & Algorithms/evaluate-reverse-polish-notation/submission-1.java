class Solution {
    public int evalRPN(String[] tokens) {
        int sum = 0;
        Stack<Integer> stk = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int val1 = stk.pop();
                int val2 = stk.pop();
                switch(token){
                    case "+":
                        stk.add(val1+val2);
                        break;
                    case "-":
                        stk.add(val2-val1);
                        break;
                    case "*":
                        stk.add(val1*val2);
                        break;
                    case "/":
                        stk.add(val2/val1);
                        break;
                }
            } else{
                stk.add(Integer.parseInt(token));
            }
        }
        return stk.pop();
    }
}
