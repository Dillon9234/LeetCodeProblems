class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int curBest = 0;
        int curLast = 0;
        for(int i= 0;i<n-1;i++){
            curBest =  Math.max(curBest, i+nums[i]);
            if(curBest>=n-1)
                return jumps+1;
            if(i == curLast){
                jumps++;
                curLast = curBest;
            }
        }
        return jumps;
    }
}
