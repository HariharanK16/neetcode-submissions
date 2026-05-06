class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }

        int curr = 2, prev = 1, count  = 0;

        int i = 3;
        while(i<=n){
            count = curr + prev;
            prev = curr;
            curr = count;
            i++;
        }
        return count;
    }
}
