class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Integer, List<int[]>> distToPoints = new HashMap<>();
        PriorityQueue<Integer> maxpq= new PriorityQueue<>(Collections.reverseOrder());


        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            maxpq.offer(dist);
            distToPoints.computeIfAbsent(dist, d -> new ArrayList<>()).add(point);

            if (maxpq.size() > k) {
                int distRemove = maxpq.poll();
                List<int[]> list = distToPoints.get(distRemove);
                list.remove(list.size() - 1);   // drop one point at that distance
            }
        }

        int[][] res = new int[k][];
        int i = 0;
        while (!maxpq.isEmpty()) {
            int distRes = maxpq.poll();
            List<int[]> list = distToPoints.get(distRes);
            res[i++] = list.remove(list.size() - 1);
        }
        return res;

    }
}
