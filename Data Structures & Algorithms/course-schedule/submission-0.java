class Solution {
    // mapping each course to its prerequisites
    private Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();

    // Store all courses along the current DFS path
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {


        for(int i = 0; i < numCourses; i++){
            prerequisiteMap.put(i, new ArrayList<>());

        }
        for(int [] prereq : prerequisites){
            prerequisiteMap.get(prereq[0]).add(prereq[1]);
        }

        for (int i = 0; i < numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }
        private boolean dfs(int course){
            if(visiting.contains(course)){
                return false;
            }
            
            if(prerequisiteMap.get(course).isEmpty()){
                return true;
            }

            visiting.add(course);
            for(int pre : prerequisiteMap.get(course)){
                if(!dfs(pre)){
                    return false;
                }
            }
            visiting.remove(course);
            prerequisiteMap.put(course, new ArrayList<>());
            return true;
        }

}
