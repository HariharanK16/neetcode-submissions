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
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[]{k,0};
        getKthSmallest(root, res);
        return res[1];
    }

    private void getKthSmallest(TreeNode root, int[] res){
        if(root == null) return;

        getKthSmallest(root.left,res);
        res[0]--;
        if(res[0]==0) {
            res[1] = root.val;
            return;
        }
        
        getKthSmallest(root.right,res);
    }
}
