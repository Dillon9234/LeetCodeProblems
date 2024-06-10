class Solution {
    int matrix[][];
    boolean[][] visited;
    int m;
    int n;
    List<Integer> output;
    int x,y;
    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        output = new ArrayList<>();
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        x = 0;
        y = 0;
        while(true){
            if(!right()||!down()||!left()||!up())
                break;
        }
        return output;
    }

    public boolean right(){
        if(x<0||y<0||x>=m||y>=n||visited[x][y])
            return false;
        while(true){
            output.add(matrix[x][y]);
            visited[x][y] = true;
            if(y+1<n&&!visited[x][y+1])
                y++;
            else
                break;
        }
        x++;
        return true;
    }
    public boolean down(){
        if(x<0||y<0||x>=m||y>=n||visited[x][y])
            return false;
        while(true){
            output.add(matrix[x][y]);
            visited[x][y] = true;
            if(x+1<m&&!visited[x+1][y])
                x++;
            else
                break;
        }
        y--;
        return true;
    }

    public boolean left(){
        if(x<0||y<0||x>=m||y>=n||visited[x][y])
            return false;
        while(true){
            output.add(matrix[x][y]);
            visited[x][y] = true;
            if(y-1>=0&&!visited[x][y-1])
                y--;
            else
                break;
        }
        x--;
        return true;
    }

    public boolean up(){
        if(x<0||y<0||x>=m||y>=n||visited[x][y])
            return false;
        while(true){
            output.add(matrix[x][y]);
            visited[x][y] = true;
            if(x-1>=0&&!visited[x-1][y])
                x--;
            else
                break;
        }
        y++;
        return true;
    }
    
}
