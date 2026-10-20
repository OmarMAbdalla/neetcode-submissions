class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if(!dfs(0, -1, adjList, visited)){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int root,int parent, List<List<Integer>> adjList, boolean[] visited){
        if(visited[root]){
            return false;
        }
        visited[root]= true;
        for(int nei : adjList.get(root)){
            if(nei != parent){
                if(!dfs(nei,root,adjList,visited)){
                    return false;
                }
            }
        }

        return true;
    }
}
