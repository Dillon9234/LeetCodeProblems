class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Math.min(m,n);
        int maxlength = 0;
        boolean temp;
        boolean[][][] dp = new boolean[min+1][m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[1][i][j] = matrix[i][j]=='1';
                if(dp[1][i][j])
                    maxlength = 1;
            }
        }
        for(int i=2;i<=min;i++){
            temp = false;
            for(int j = 0;j<m+1-i;j++){
                for(int k=0;k<n+1-i;k++){
                    dp[i][j][k] = dp[i-1][j][k]&&dp[i-1][j+1][k]&&dp[i-1][j+1][k+1]&&dp[i-1][j][k+1];
                    if(dp[i][j][k]){
                        temp = true;
                    }
                }
            }
            if(temp){
                maxlength = i;
            }else{
                break;
            }
        }

        return maxlength*maxlength;
    }
}
