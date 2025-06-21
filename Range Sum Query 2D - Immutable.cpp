class NumMatrix {
public:
    vector<vector<int>> numMatrix;
    int n;
    int m;
    NumMatrix(vector<vector<int>>& matrix) {
        m = matrix.size();
        n = matrix[0].size();
        numMatrix = vector<vector<int>>(m+1, vector<int>(n+1, 0));
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                numMatrix[i][j] = matrix[i-1][j-1] + numMatrix[i][j-1] + numMatrix[i-1][j] - numMatrix[i-1][j-1];
            }
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        return numMatrix[row2+1][col2+1] + numMatrix[row1][col1] - numMatrix[row2+1][col1] - numMatrix[row1][col2+1];
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */
