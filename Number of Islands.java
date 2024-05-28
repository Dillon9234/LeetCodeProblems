class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == '0'||visited[i][j] == true)
                    continue;
                DFS(grid, visited, m, n, i, j);
                count++;
            }
        }
        return count;
    }

    private void DFS(char[][] grid, boolean[][] visited, int m, int n, int x, int y){
        if(x<0||y<0||x>=m||y>=n||visited[x][y] == true || grid[x][y]=='0')
            return;
        visited[x][y] = true;
        DFS(grid, visited, m, n, x-1,y);
        DFS(grid, visited, m, n,x, y-1);
        DFS(grid, visited, m, n,x+1, y);
        DFS(grid, visited, m, n,x, y+1);
    }
}
