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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        return find(root, Integer.MIN_VALUE);
    }

    private int find(TreeNode root, int max){
        if(root == null){
            return 0;
        }

        int left = find(root.left, Math.max(max,root.val));
        int right = find(root.right, Math.max(max,root.val));

        int curr = root.val >= max ? 1 : 0;

        return left + right + curr;
    }
}
