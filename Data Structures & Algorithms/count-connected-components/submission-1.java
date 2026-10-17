class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean [n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                Queue<Integer> queue = new LinkedList<>();
                count++;
                queue.add(i);
                while(!queue.isEmpty()){
                    int tmp = queue.remove();
                    visited[tmp] = true;

                    for(int nei : adj.get(tmp)){
                        if(!visited[nei]){
                            visited[nei] = true;
                            queue.add(nei);
                        }
                    }
                }
            }

        }
        return count;
    }
}
