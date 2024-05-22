public class snakesAndLadders {
    int pos;
    int steps;
    public snakesAndLadders(int pos, int steps) {
        this.pos = pos;
        this.steps = steps;
    }
}

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int cur[] = {n-1,0};
        boolean[] visited = new boolean[n*n+1];
        Queue<snakesAndLadders> queue = new LinkedList<>();

        queue.add(new snakesAndLadders(1,0));
        int temp;
        snakesAndLadders point;
        int next;

        while(!queue.isEmpty()){
            point = queue.remove();
            for(int i = point.pos+1;i<=point.pos+6;i++){
                cur = convert(i, n);
                temp = board[cur[0]][cur[1]];
                if(temp==-1)
                    next = i;
                else
                    next = temp;
                if(next == n*n)
                    return  point.steps+1;
                if(!visited[next]){
                    visited[next]=true;
                    queue.add(new snakesAndLadders(next, point.steps+1));
                }
            }
        }
        return -1;
    }
    private int[] convert(int num,int n){
        num--;
        boolean isEven = (n%2 == 0);
        int ans[] = new int[2];
        ans[0] = n-num/n-1;
        if(isEven){
            if(ans[0]%2==0)
                ans[1] = n - num%n-1;
            else
                ans[1] = num%n;
        }else{
            if(ans[0]%2==1)
                ans[1] = n - num%n-1;
            else
                ans[1] = num%n;
        }
        return ans;
    }
}
