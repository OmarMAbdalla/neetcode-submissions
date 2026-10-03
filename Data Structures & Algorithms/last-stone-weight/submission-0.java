class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            heap.add(stone);
        }

        while(heap.size() > 1){
            int max = heap.poll();
            int second = heap.poll();

            heap.add(max-second);
        }
        return heap.poll();
    }
}
