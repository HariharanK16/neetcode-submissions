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

    Pair<Integer,Boolean> findBalance(TreeNode root) {
        if(root == null) return new Pair<>(0,true);

        Pair<Integer,Boolean> left = findBalance(root.left);
        Pair<Integer,Boolean> right = findBalance(root.right);

        boolean isbalanced = left.getValue() && right.getValue() && Math.abs(left.getKey() - right.getKey()) <=1;

        return new Pair<>(1 + Math.max(left.getKey(),right.getKey()),isbalanced);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return findBalance(root).getValue();
    }
}
