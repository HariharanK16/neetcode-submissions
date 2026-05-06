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
    int pre_ind = 0;
    Map<Integer,Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;

        for(int i = 0;i<inorder.length;i++){
            indices.put(inorder[i],i);
        } 

        return dfs(preorder,0,inorder.length - 1);
    }

    private TreeNode dfs(int[] po, int l, int r){
        if(l>r) return null;
        int root_val = po[pre_ind++];
        TreeNode root = new TreeNode(root_val);
        int ioi = indices.get(root_val);
        root.left = dfs(po, l, ioi-1);
        root.right = dfs(po, ioi+1, r);
        return root;
    }
}
