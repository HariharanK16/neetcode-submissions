class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;
        int output = 0;
        while(j<n){
            System.out.println("i->"+nums[i]);
            System.out.println("j->"+nums[j]);
            System.out.println();
            if(nums[i]==0){
                i++;
                j = i+1;
            }
            if(nums[j]>0){
                int k = i + 1;
                int min = Math.min(nums[i],nums[j]);
                while(k<j){
                    if(nums[k]<min){
                        int diff = Math.abs(min-nums[k]);
                        output+=diff;
                        nums[k]+=diff;
                    }

                    k++;
                }
                if(nums[i]<nums[j]){
                    i = j;
                }
                j++;
            } else{
                j++;
            }
        }
        return output;
    }
}
