/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    int[][] grid;
    private Node helper(int n,int x, int y){
        Node root = new Node(true, false);
        if(n == 1||checkAllSame(x, y, n)){
            root.isLeaf = true;
            root.val = grid[x][y]!=0;
            return root;
        }
        n/=2;
        root.topLeft = helper(n, x, y);
        root.topRight = helper(n, x, y+n);
        root.bottomLeft = helper(n, x+n, y);
        root.bottomRight = helper(n, x+n, y+n);
        return root;
    }

    private boolean checkAllSame(int x, int y, int n){
        for(int i = x;i<x+n;i++){
            for(int j = y;j<y+n;j++){
                if(grid[i][j]!=grid[x][y])
                    return false;
            }
        }
        return true;
    }
    public Node construct(int[][] grid) {
        int n = grid.length;
        this.grid = grid;
        Node root = new Node(true, false);
        root =  helper(n,0,0);
        return root;
    }
}
