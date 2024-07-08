class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0);
    }

    public boolean helper(char[][] board, int pos){
        if(pos == 81){
            return true;
        }
        int row = pos/9;
        int col = pos%9;
        if(board[row][col]=='.'){
            for(int i=1;i<=9;i++){
                if(isValid(board,row,col,(char) ('0' + i))){
                    board[row][col] = (char) ('0' + i);
                    if(helper(board,pos+1))
                        return true;
                } 
            }
            board[row][col] = '.';
        }else{
            if(helper(board,pos+1))
                return true;
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char input){
         for (int i = 0; i < 9 ; i++) {
            if(board[i][col] == input)
                return false;
            if(board[row][i] == input)
                return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == input)
                return false;
         }
         return true;
    }
}
