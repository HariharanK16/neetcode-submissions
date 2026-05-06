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
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;

        calculateMaxValue(root);
        return maxValue;
    }

    private int calculateMaxValue(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(calculateMaxValue(root.left),0);
        int rightMax = Math.max(calculateMaxValue(root.right),0);

        maxValue = Math.max(maxValue, root.val + leftMax + rightMax);

        int max = Math.max(leftMax, rightMax);
        int res = root.val;
        if(max>0){
            res += max;
        }
        return res;
    }
}
