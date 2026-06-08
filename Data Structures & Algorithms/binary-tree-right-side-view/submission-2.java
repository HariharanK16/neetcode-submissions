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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode right = null;
            
            int n = queue.size();

            for(int i = 0;i<n;i++){
                TreeNode node = queue.poll();
               
                if(node!=null){
                    right = node;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(right != null)
            result.add(right.val);
        }
        return result;
    }
}
