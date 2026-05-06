class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            map.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0;i<numCourses;i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course){
        if(visit.contains(course)) return false;

        if(map.get(course).isEmpty()) return true;

        visit.add(course);

        for(int i:map.get(course)){
            if(!dfs(i)) return false;
        }
        visit.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
