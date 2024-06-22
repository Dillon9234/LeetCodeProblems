class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]%2 == 0){
                    count = 0;
                    if(j-1>=0){
                        count += board[i][j-1]%2;
                        if(i-1>=0){
                            count += board[i-1][j-1]%2;
                        }
                        if(i+1<m){
                            count += board[i+1][j-1]%2;
                        }
                    }
                    if(j+1<n){
                        count += board[i][j+1]%2;
                        if(i-1>=0){
                            count +=board[i-1][j+1]%2;
                        }
                        if(i+1<m){
                            count +=board[i+1][j+1]%2;
                        }
                    }
                    if(i-1>=0){
                        count +=board[i-1][j]%2;
                    }
                    if(i+1<m){
                        count +=board[i+1][j]%2;
                    }
                    if(count==3){
                        board[i][j] = 2;
                    }
                }else{
                    count = 0;
                    if(j-1>=0){
                        count += board[i][j-1]%2;
                        if(i-1>=0){
                            count += board[i-1][j-1]%2;
                        }
                        if(i+1<m){
                            count += board[i+1][j-1]%2;
                        }
                    }
                    if(j+1<n){
                        count += board[i][j+1]%2;
                        if(i-1>=0){
                            count +=board[i-1][j+1]%2;
                        }
                        if(i+1<m){
                            count +=board[i+1][j+1]%2;
                        }
                    }
                    if(i-1>=0){
                        count +=board[i-1][j]%2;
                    }
                    if(i+1<m){
                        count +=board[i+1][j]%2;
                    }
                    if(count<2){
                        board[i][j] = 3;
                    }else if(count>3){
                        board[i][j] = 3;
                    }
                }

            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j] = 1;
                }else if(board[i][j]==3){
                    board[i][j] = 0;
                }
            }
        }
    }
}
