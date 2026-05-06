class Solution {

    public int bs(int i, int j, int[] nums, int t){
        if(i>j){
            return -1;
        }
        int mid = ((j-i)/2)+i;
        if(nums[mid]==t){
            return mid;
        }else if(nums[mid]>t){
            return bs(i,mid-1,nums,t);

        }else{
            return bs(mid+1,j,nums,t);
        }
    }
    public int search(int[] nums, int target) {
        return bs(0,nums.length-1, nums, target);
    }
}
