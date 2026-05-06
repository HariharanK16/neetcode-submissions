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
        findSum(root);
        return maxSum;
    }
    public int findSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int lm = Math.max(findSum(root.left),0);
        int rm = Math.max(findSum(root.right),0);

        maxSum = Math.max(lm+rm+root.val,maxSum);

        return root.val + Math.max(lm,rm);
    }
}
