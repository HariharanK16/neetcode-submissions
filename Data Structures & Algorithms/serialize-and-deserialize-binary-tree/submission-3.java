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
        dfs(root,res);
        return String.join(",",res);
    }
    private void dfs(TreeNode root, List<String> res){
        if(root == null){
            res.add("null");
            return; 
        }
        res.add(root.val+"");
        dfs(root.left,res);
        dfs(root.right,res);
        return;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        int[] ind = new int[]{0};
        return dfds(res,ind);
    }

    private TreeNode dfds(String[] res, int[] ind){
        if(res[ind[0]].equals("null")){
            ind[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(res[ind[0]++]));

        root.left = dfds(res,ind);
        root.right = dfds(res,ind);
        return root;
    }
}
