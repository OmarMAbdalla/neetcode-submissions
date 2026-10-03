class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    }
    
    public void addNum(int num) {
        if(maxHeap.peek() == null ){
            maxHeap.add(num);
            return;
        }
        if(minHeap.peek() == null){
            if(maxHeap.peek() > num){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
            return;

        }
        if(minHeap.size() == maxHeap.size()){
            if (num > minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }else{
                maxHeap.add(num);
            }
        }else{
            if (num < maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }  
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return ((double)minHeap.peek()+maxHeap.peek())/2;
        }
        return maxHeap.peek();
    }
}
