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
    int pi = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return bst(preorder,0, inorder.length - 1);
    }

    private TreeNode bst(int[] po, int l, int r){
        if(l>r) return null;
        int val = po[pi++];
        TreeNode root = new TreeNode(val);
        int ind = map.get(val);
        root.left = bst(po,l,ind - 1);
        root.right = bst(po,ind+1,r);
        return root;
        
    }

}
