class Solution {
    public int jump(int[] nums) {
        int r = 0,l=0, res = 0;

        while(r<nums.length-1){
            int further = 0;

            for(int i = l ;i<=r;i++){
                further = Math.max(further, i+nums[i]);
            }

            l = r + 1;
            r = further;
            res++;
        }
        return res;
    }
}
