class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i =0;i<n;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return dfs(0,-1) && n == visit.size();
    }

    private boolean dfs(int i, int par){
        if(visit.contains(i)) return false;

        visit.add(i);

        for(int j:map.get(i)){
            if(j==par) continue;
            if(!dfs(j,i)) return false;
        }

        return true;
    }
}
