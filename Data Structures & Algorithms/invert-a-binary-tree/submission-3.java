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
    private void invert(TreeNode root){
        if(root == null){
            return;
        }


        // if(root.left!=null){
         invert(root.left);
        // }
        // if(root.right!=null){
            invert(root.right);
        // }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = root.right;
        // if(root.left!=null){
        root.right = invertTree(root.left);
        // }
        // if(root.right!=null){
        root.left = invertTree(temp);
        // }
        // TreeNode tmp = root.left;
        // root.left = root.right;
        // root.right = tmp;
        return root;
    }
}
