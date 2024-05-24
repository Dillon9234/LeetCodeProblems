class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];
        int n = coins.length;
        Arrays.sort(coins);
        minCoins[0] = 0;
        for(int i =1;i<=amount;i++){
                minCoins[i] = amount+1;
                for(int j = 0; j<n && coins[j]<=i;j++){
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coins[j]]+1);
                }
        }
        return minCoins[amount] != amount+1 ? minCoins[amount]:-1;
    }
}
