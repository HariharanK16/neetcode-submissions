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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return List.of();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            
            int n = queue.size();

            for(int i = 0;i<n;i++){
                TreeNode node = queue.poll();
               
                if(node!=null){
                    temp.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(temp.size() > 0)
            result.add(temp);
        }
        return result;
    }
}
