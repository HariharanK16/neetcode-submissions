class Solution {
    public boolean bs(int l, int r, int nums[], int t){
        if(l>r) return false;
        System.out.println(l+" "+r+" "+t);
        int mid = ((r-l)/2)+l;
        if(nums[mid]==t){
            return true;
        } else if (nums[mid]>t){
            return bs(l,mid-1,nums,t);
        } else {
            return bs(mid+1,r,nums,t);
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n<1){
            return false;
        }
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            if(matrix[i][m-1]>=target){
                return bs(0,m-1,matrix[i],target);
            }
        }
        return false;
    }
}
