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
    private int max = 0;

    private int diameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int lMax = diameter(root.left);
        int rMax = diameter(root.right);
        max = Math.max(max,lMax+rMax);
        return 1 + Math.max(lMax,rMax);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

       diameter(root);
        return max;
    }
}
