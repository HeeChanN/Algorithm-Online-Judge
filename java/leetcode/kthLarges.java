class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int capacity;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        addAll(nums);
        removeNumber();
    }
    
    public int add(int val) {
        pq.offer(val);
        removeNumber();
        return pq.peek();
    }

    private void addAll(int [] nums){
        for(int i = 0; i<nums.length; i++){
            pq.offer(nums[i]);
        }
    }

    private void removeNumber(){
        while(pq.size() > capacity){
            pq.poll();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
