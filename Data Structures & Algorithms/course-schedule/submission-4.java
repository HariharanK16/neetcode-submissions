class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();;
    Set<Integer> visit = new HashSet<>();;
    public boolean canFinish(int numCourses, int[][] pr) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] prereq : pr) {
            map.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0;i<numCourses;i++){
            if(!dfs(i)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i){
        if(visit.contains(i)){
            return false;
        }

        if(map.get(i).isEmpty()){
            return true;
        }
        visit.add(i);
        for(int j:map.get(i)){
            if(!dfs(j)){
                return false;
            }
        }
        visit.remove(i);
        map.put(i,new ArrayList());
        return true;
    }
}
