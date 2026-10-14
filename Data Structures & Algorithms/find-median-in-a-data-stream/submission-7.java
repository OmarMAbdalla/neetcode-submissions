class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        if(minHeap.size()> maxHeap.size()){
            if(minHeap.peek() <num){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }else{
                maxHeap.offer(num);
            } 
            return;           
        }
        if(!maxHeap.isEmpty() && maxHeap.peek() > num){
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(num);
            return;
        }

        minHeap.offer(num);
        return;
        
    }
    
    public double findMedian() {
        if(minHeap.size()>maxHeap.size()){
            return (double) minHeap.peek();
        }
        return (double) (minHeap.peek() + maxHeap.peek()) / 2;
    }
}
