class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        for(int i=0;i<n-1;i++){
            if(prices[i]<prices[i+1]){
                max += prices[i+1]-prices[i];
            }
        }
        return max;
    }

}

DP(Wayyy slower):
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                dp[j] = Math.max(dp[i]+prices[j-1]-prices[i-1],dp[i]);
            }
        }
        return dp[n];
    }

}
