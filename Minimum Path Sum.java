class Solution {
    int[][] grid;
    int n;  
    int m;
    Integer[][] DP;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        DP = new Integer[m][n];
        DP[0][0] = grid[0][0];
        return helper(m-1, n-1);
    }

    private int helper(int x, int y){
        if(x<0||y<0)
            return Integer.MAX_VALUE;
        if(DP[x][y]!=null)
            return DP[x][y];
        int left,top;
        left = helper(x, y-1);
        top = helper(x-1, y);
        return DP[x][y] = grid[x][y]+Math.min(left,top);
    }
}
