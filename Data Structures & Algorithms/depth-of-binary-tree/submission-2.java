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

    private int depth(TreeNode root, int d){
        if(root == null){
            return 0;
        }
        int ld = depth(root.left, d+1);
        int rd = depth(root.right,d+1);

        return 1 + Math.max(ld,rd);
    }
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        return depth(root,0);
    }
}
