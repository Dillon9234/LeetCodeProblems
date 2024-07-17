class Solution {
    Integer[] dp;
    public int numTrees(int n) {
        if(n == 1)
            return 1;
        dp = new Integer[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return helper(n);
    }

    private int helper(int n){
        if(dp[n] != null)
            return dp[n];
        int sum =0;
        for(int i=0;i<n;i++){
            sum += helper(i)*helper(n-i-1);
        }
        return dp[n] = sum;
    }
}
