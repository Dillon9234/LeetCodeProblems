Using Backtracking (not optimal):
class Solution {
    PriorityQueue<Integer> queue;
    HashSet<Integer> inQueue;
    int n;
    public int nthUglyNumber(int n) {
        this.n = n;
        queue = new PriorityQueue<>(Comparator.reverseOrder());
        inQueue = new HashSet<>();
        helper(1);

        return queue.poll();
    }

    private void helper(long cur){
        if(!addToQueue(cur))
            return;
        helper(cur*2);
        helper(cur*3);
        helper(cur*5);
    }

    private boolean addToQueue(long element){
        if(element>Integer.MAX_VALUE)
            return false;
        int elementInt = (int) element;
        if(inQueue.contains(elementInt))
            return false;
        if(queue.size()<n){
            queue.add(elementInt);
            inQueue.add(elementInt);
            return true;
        }else{
            if(queue.peek()>elementInt){
                queue.poll();
                queue.add(elementInt);
                inQueue.add(elementInt);
                return true;
            }
            return false;     
        }
    }

}

Using DP:

  class Solution {
    public int nthUglyNumber(int n) {
        int ptr1 = 0,ptr2 = 0,ptr3 = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i=1;i<n;i++){
            dp[i] = Math.min(dp[ptr1]*2,Math.min(dp[ptr2]*3,dp[ptr3]*5));
            if(dp[i] == dp[ptr1]*2)
                ptr1++;
            if(dp[i] == dp[ptr2]*3)
                ptr2++;
            if(dp[i] == dp[ptr3]*5)
                ptr3++;
        }

        return dp[n-1];
    }

}
