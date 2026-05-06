class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visit = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prs) {
        for(int i = 0;i<numCourses;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pr:prs){
            map.get(pr[0]).add(pr[1]);
        }

        for(int i = 0;i<numCourses;i++){
            if(!dfs(i)) return new int[]{};
        }

        int ind = 0;
        int output[] = new int[res.size()];
        for(int i:res){
            output[ind] = i;
            ind++;
        }
        return output;
    }

    private boolean dfs(int i){
        if(cycle.contains(i)) return false;
        if(visit.contains(i)) return true;

        cycle.add(i);

        for(int j:map.get(i)){
            if(!dfs(j)) return false;
        }

        cycle.remove(i);
        visit.add(i);
        res.add(i);
        return true;
    }
}
