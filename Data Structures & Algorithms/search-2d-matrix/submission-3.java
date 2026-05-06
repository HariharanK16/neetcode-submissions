class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length*matrix[0].length-1;
        int l = 0;
        while(l<=r){
            int m = l + (r-l)/2;
            int row = m / matrix[0].length, col = m % matrix[0].length;
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col]>target){
                r = m - 1;
            } else{
                l = m+1;
            }
        }
        return false;
    }
}
