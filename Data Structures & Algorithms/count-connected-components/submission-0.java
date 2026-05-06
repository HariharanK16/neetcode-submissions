class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        int comps = 0;

        for(int i = 0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int prevSize = visit.size();
        for(int i = 0;i<n;i++){
            dfs(i);
            if(visit.size()!=prevSize){
                prevSize = visit.size();
                comps++;
            }
        }
        return comps;
    }

    public void dfs(int i){
        if(visit.contains(i)){
            return;
        }
        visit.add(i);
        for(int j:map.get(i)){
            dfs(j);
        }
    }
}
