class Solution {
    PriorityQueue<Integer> queue;
    int k;
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        queue = new PriorityQueue<>();
        this.k = k;
        for(int i=0;i<n;i++){
            insertIntoQueue(nums[i]);
        }
        return queue.poll();
    }

    private void insertIntoQueue(int num){
        if(queue.size()<k)
            queue.add(num);
        else{
            if(num>queue.peek()){
                queue.poll();
                queue.add(num);
            }
        }
    }

}
