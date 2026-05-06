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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> cols = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int pos = p.getValue();

            cols.computeIfAbsent(pos, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) queue.offer(new Pair<>(node.left, pos - 1));
            if (node.right != null) queue.offer(new Pair<>(node.right, pos + 1));
        }

        return new ArrayList<>(cols.values());
    }
}