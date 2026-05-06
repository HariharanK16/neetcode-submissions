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

// class Solution {
//     List<Integer> list;
//     public int kthSmallest(TreeNode root, int k) {
//         list = new ArrayList<>();
//         dfs(root);
//         return list.get(k-1);
//     }

//     private void dfs(TreeNode root) {
//         if(root == null){
//             return;
//         }
//         dfs(root.left);
//         list.add(root.val);
//         dfs(root.right);
//     }
// }

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        dfs(root, tmp);
        return tmp[1];
    }

    private void dfs(TreeNode node, int[] tmp) {
        if (node == null) {
            return;
        }

        dfs(node.left, tmp);
        tmp[0] -= 1;
        if (tmp[0] == 0) {
            tmp[1] = node.val;
            return;
        }
        dfs(node.right, tmp);
    }
}