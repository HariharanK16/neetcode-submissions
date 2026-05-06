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
        List<Integer> arr = new ArrayList<>();

        dfs(root, arr,k);
        // Collections.sort(arr);
        return arr.get(k - 1);
    }

    private void dfs(TreeNode node, List<Integer> arr, int k) {
        if (node == null) {
            return;
        }
        if(arr.size()==k){
            return;
        }
        
        dfs(node.left, arr, k);
        arr.add(node.val);
        dfs(node.right, arr, k);
    }
}