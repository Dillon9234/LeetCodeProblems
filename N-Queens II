class Solution {

    int count;
    public int totalNQueens(int n) {
        count = 0;
        int board[][] = new int[n][n];
        myFn(board,n,0);
        return count;
    }

    private void myFn(int board[][],int n,int row){
        if(row == n){
            count++;
            return;
        }

        if(row == 0){
            for(int i=0;i<n;i++){
                board[row][i] = 1;
                myFn(board,n,row+1);    
                board[row][i] = 0;
            }
            return;
        }

        for(int i=0;i<n;i++){
            board[row][i] = 1;
            if(!HVTest(board,n,i)){
                board[row][i] = 0;
                continue;
            }
                
            if(!diagonalTest(board,n,row,i)){
                board[row][i] = 0;
                continue;
            }
            myFn(board,n,row+1);
            board[row][i] = 0;
        }
    }
    private boolean HVTest(int board[][],int n ,int y){
        int sum = 0;
        for(int i=0;i<n;i++)
            sum+= board[i][y];
        if(sum>1)
            return false;
        return true;
    }

    private boolean diagonalTest(int board[][],int n ,int x,int y){
        int sum = 0;
        int tX = x,tY = y;
        while(tX<n&&tY<n)
            sum += board[tX++][tY++];
        if(sum>1)
            return false;
            
        tX = x;
        tY = y;
        sum = 0;
        while(tX>=0&&tY>=0)
            sum += board[tX--][tY--];
        if(sum>1)
            return false;

        tX = x;
        tY = y;
        sum = 0;

        while(tX>=0&&tY<n)
            sum += board[tX--][tY++];
        if(sum>1)
            return false;

        tX = x;
        tY = y;
        sum = 0;

        while(tX<n&&tY>=0)
            sum += board[tX++][tY--];
        if(sum>1)
            return false;
        return true;
    }
}
