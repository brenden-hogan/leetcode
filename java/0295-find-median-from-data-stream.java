class MedianFinder {
        
    //Put larger number here
    PriorityQueue<Integer> minQ = new PriorityQueue<>((n1,n2)->n1-n2);
    //Put smaller numbers here
    PriorityQueue<Integer> maxQ = new PriorityQueue<>((n1,n2)->n2-n1);        

    public MedianFinder() {
    }
    
    public void addNum(int num) {
     
        if(minQ.size() == 0 || minQ.peek() < num){
            minQ.add(num);
        } else {
            maxQ.add(num);
        }
        
        if (minQ.size() > maxQ.size()+1){
            maxQ.add(minQ.poll());
        } else if (maxQ.size()>minQ.size()){
            minQ.add(maxQ.poll());
        }
        
    }
    
    public double findMedian() {
        
        if (minQ.size()==maxQ.size()){
            return minQ.peek()/2.0 + maxQ.peek()/2.0;
        } else {
            return minQ.peek();
        }        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */