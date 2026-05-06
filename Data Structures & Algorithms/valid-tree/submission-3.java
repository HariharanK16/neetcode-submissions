class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i = 0 ;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return dfs(0,-1) && n == visit.size();
    }

    public boolean dfs(int node, int par){
        if(visit.contains(node)){
            return false;
        }

        visit.add(node);
        for(int i : map.get(node)){
            if(i==par){
                continue;
            }
            if(!dfs(i,node)) return false;
        }
        return true;
    }
}
