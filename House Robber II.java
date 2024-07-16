class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0],nums[1]);
        return Math.max(helper(nums,0,n-2,n),helper(nums,1,n-1,n));
    }

    private int helper(int[] nums, int start, int end, int n){
        int[] dp = new int[n];
        int max = nums[start];
        dp[start] = nums[start];
        if(start+1<=end){
            dp[start+1] = Math.max(dp[start],nums[start+1]);
            max = Math.max(max,dp[start+1]);
        }
        for(int i=start+2;i<=end;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
