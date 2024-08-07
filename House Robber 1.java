class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        if(1<n){
            dp[1] = Math.max(nums[0],nums[1]);
            max = Math.max(max,dp[1]);
        }
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}
