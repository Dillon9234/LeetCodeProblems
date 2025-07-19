class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int vertical;
        int horizontal;
        final int max = n*m;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    continue;
                }
                vertical = max;
                horizontal = max;
                if(i>0){
                    vertical = mat[i-1][j];
                }
                if(j>0){
                    horizontal = mat[i][j-1];
                }
                mat[i][j] = Math.min(vertical,horizontal) + 1;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(mat[i][j] == 0){
                    continue;
                }
                vertical = max;
                horizontal = max;
                if(i<n-1){
                    vertical = mat[i+1][j];
                }
                if(j<m-1){
                    horizontal = mat[i][j+1];
                }
                mat[i][j] = Math.min((Math.min(vertical,horizontal) + 1),mat[i][j]);
            }
        }
        return mat;
    }
}
