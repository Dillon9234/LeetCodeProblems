class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;
        int mid;
        int x,y;
        while(left<=right){
            mid = left + (right-left)/2;
            x = mid/n;
            y = mid%n;
            if(matrix[x][y]==target)
                return true;
            else if(matrix[x][y]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
