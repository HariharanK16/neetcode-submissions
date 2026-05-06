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
    public TreeNode buildTree(int[] po, int[] io) {
        if(po.length==0 || io.length==0){
            return null;
        }

        TreeNode node = new TreeNode(po[0], null, null);
        int mid = 0;
        for(;mid<io.length;mid++){
            if(po[0]==io[mid]){
                break;
            }
        }
        node.left = buildTree(Arrays.copyOfRange(po,1,mid+1),Arrays.copyOfRange(io,0,mid));
        node.right = buildTree(Arrays.copyOfRange(po,mid+1,po.length),Arrays.copyOfRange(io,mid+1,io.length));
        return node;
    }
}
