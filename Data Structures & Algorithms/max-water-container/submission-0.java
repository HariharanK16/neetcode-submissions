class Solution {
    public int maxArea(int[] h) {
        int n = h.length;
        if(n==0)
            return 0;
        int i = 0;
        int j = n-1;

        int max = 0;
        while(i<j){
            int min = Math.min(h[i],h[j]);
            max = Math.max(min*(j-i),max);
            System.out.println("i->"+i+" j->"+j+" max: "+max);
            System.out.println("i val->"+h[i]+" j val->"+h[j]);
            if(h[i]<h[j]){
                i++;
            }else{j--;}
        }
        return max;
    }
}
