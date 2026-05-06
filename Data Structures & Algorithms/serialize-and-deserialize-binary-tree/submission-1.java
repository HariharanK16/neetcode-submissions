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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialise(root, res);
        return String.join(",", res);
    }

    public void dfsSerialise(TreeNode root, List<String> res) {
        if(root==null){
            res.add("null");
            return;
        }
        
        res.add(root.val+ "");
        dfsSerialise(root.left, res);
        dfsSerialise(root.right, res);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfsDeserialize(vals, i);
    }

    private TreeNode dfsDeserialize(String[] vals, int[] i) {
        if (vals[i[0]].equals("null")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(vals, i);
        node.right = dfsDeserialize(vals, i);
        return node;
    }
}
