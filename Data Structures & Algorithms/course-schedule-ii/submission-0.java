class Solution {

    Map<Integer,List<Integer>> map = new HashMap<>();;
    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            map.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0;i<numCourses;i++){
            if(!dfs(i)){
                return new int[0];
            }
        }

        int op[] = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            op[i] = res.get(i);
        }
        return op;
    }

    private boolean dfs(int i){
        if(cycle.contains(i)){
            return false;
        }
        if(visit.contains(i)){
            return true;
        }

    
        cycle.add(i);
        for(int j:map.get(i)){
            if(!dfs(j)){
                return false;
            }
        }
        cycle.remove(i);
        res.add(i);
        visit.add(i);
        return true;
    }
}
