class Solution {
    double[][][] board;
    private static final int[][] KNIGHT_MOVES = {
        {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
        {2, -1}, {2, 1}, {1, -2}, {1, 2}
    };
    public double knightProbability(int n, int k, int row, int column) {
        if(k==0)
            return 1;
        board = new double[n][n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(board[i][j], -1);
            }
        }

        return helper(n,k,row,column);
    }
    
    double helper(int n, int k, int row, int column){
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }
        if(k == 0)
            return 1.0;
        if(board[row][column][k]!=-1){
            return board[row][column][k];
        }
        double cur = 0.0;
        for (int[] move : KNIGHT_MOVES) {
            cur += helper(n, k - 1, row + move[0], column + move[1]);
        }
        cur /= 8;
        board[row][column][k] = cur;
        return cur;
    }
}
