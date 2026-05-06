public class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        for (int i = 0; i <= n; i++) {
            adj.put(i,new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            Set<Integer> visit = new HashSet<>();

            if (!dfs(u, -1, visit)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent,
                         Set<Integer> visit) {
        if (visit.contains(node)) {
            return false;
        }

        visit.add(node);
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (!dfs(nei, node, visit)) {
                return false;
            }
        }
        return true;
    }
}