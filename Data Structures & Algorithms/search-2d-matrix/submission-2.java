class Solution {
    public boolean bs(int l, int r, int nums[][], int t){
        if(l>r) return false;
        int mid = ((r-l)/2)+l;
        int row = mid/nums[0].length, col = mid%nums[0].length;
        if(nums[row][col]==t){
            return true;
        } else if (nums[row][col]>t){
            return bs(l,mid-1,nums,t);
        } else {
            return bs(mid+1,r,nums,t);
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        return bs(0,matrix.length*matrix[0].length-1,matrix,target);
    }
}
