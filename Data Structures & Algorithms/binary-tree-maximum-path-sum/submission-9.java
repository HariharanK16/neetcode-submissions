/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return maxSum;
    }

    private int findMaxSum(TreeNode root){
        if(root == null) return 0;

        int leftMax = Math.max(findMaxSum(root.left),0);
        int rightMax = Math.max( findMaxSum(root.right),0);

        maxSum = Math.max(rightMax+leftMax+root.val,maxSum);
        return root.val + Math.max(leftMax,rightMax);
        
    }
}
