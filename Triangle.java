class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] DP = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--)
            for(int j = 0;j<i+1;j++)
                DP[i][j] = triangle.get(i).get(j) + Math.min(DP[i+1][j], DP[i+1][j+1]);
        return DP[0][0];
    }
}
