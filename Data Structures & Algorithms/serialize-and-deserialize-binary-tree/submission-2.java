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
        dfsSerialize(root,res);
        return String.join(",",res);
    }

    private void dfsSerialize(TreeNode root, List<String> res) {
        if(root == null){
            res.add("null");
            return;
        }
        res.add(root.val+"");

        dfsSerialize(root.left,res);
        dfsSerialize(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        int[] i = new int[]{0};
        return dfsDeSerialize(res,i);
    }

    private TreeNode dfsDeSerialize(String[] res, int[] i){
        if(res[i[0]].equals("null")){
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(res[i[0]++]));
        root.left = dfsDeSerialize(res,i);
        root.right = dfsDeSerialize(res,i);
        return root;
    }
}
