class Solution {
    int m,n,size;
    char[][] board;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        size = word.length();
        if(size>m*n)
            return false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true; 
                    if(helper(i,j,1,visited))
                        return true;
                }
                    
            }
        }
        return false;
    }
    private boolean helper(int x, int y, int cur, boolean[][] visited){
        if(cur == size)
            return true;
        if(x-1>=0 && !visited[x-1][y] && board[x-1][y] == word.charAt(cur)){
            visited[x-1][y] = true;
            if(helper(x-1,y,cur+1,visited))
                return true;
            visited[x-1][y] = false;
        }
        if(x+1<m && !visited[x+1][y] && board[x+1][y] == word.charAt(cur)){
            visited[x+1][y] = true;
            if(helper(x+1,y,cur+1,visited))
                return true;
            visited[x+1][y] = false;
        }
        if(y-1>=0 && !visited[x][y-1] && board[x][y-1] == word.charAt(cur)){
            visited[x][y-1] = true;
            if(helper(x,y-1,cur+1,visited))
                return true;
            visited[x][y-1] = false;
        }
        if(y+1<n && !visited[x][y+1] && board[x][y+1] == word.charAt(cur)){
            visited[x][y+1] = true;
            if(helper(x,y+1,cur+1,visited))
                return true;
            visited[x][y+1] = false;
        }
        return false;
    }
}
