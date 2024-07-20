class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        

        HashMap<Integer,List<Integer>> redMap = new HashMap<>();
        HashMap<Integer,List<Integer>> blueMap = new HashMap<>();
        
        
        int l = redEdges.length;
        int m = blueEdges.length;
        int[] output = new int[n];

        for(int i=0;i<l;i++){
            List<Integer> temp;
            temp = redMap.get(redEdges[i][0]);
            if(temp == null){
                temp = new ArrayList<>(); 
            }
            temp.add(redEdges[i][1]);
            redMap.put(redEdges[i][0],temp);
        }

        for(int i=0;i<m;i++){
            List<Integer> temp;
            temp = blueMap.get(blueEdges[i][0]);
            if(temp == null){
                temp = new ArrayList<>(); 
            }
            temp.add(blueEdges[i][1]);
            blueMap.put(blueEdges[i][0],temp);
        }
        int[] output1 = BFS(redMap,blueMap,n,0);
        int[] output2 = BFS(redMap,blueMap,n,1);
        for(int i=0;i<n;i++){
            output[i] = Math.min(output2[i],output1[i]);
            if(output[i]==Integer.MAX_VALUE)
                output[i] = -1;
        }
        return output;
    }

    private int[] BFS(HashMap<Integer,List<Integer>> redMap,HashMap<Integer,List<Integer>> blueMap,int n,int prevRed){
        int[][] output = new int[2][n];
        for(int i = 0; i < 2; i++) {
            Arrays.fill(output[i], Integer.MAX_VALUE);
        }
        
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(0,0,prevRed));
        int curPrevRed;

        while(!queue.isEmpty()){
            node cur = queue.poll();
            curPrevRed = cur.prevRed;
            output[curPrevRed][cur.n] = cur.cost;
            List<Integer> temp;
            if(curPrevRed == 0){
                temp = redMap.get(cur.n);
                if(temp!=null){
                    for(Integer num:temp){
                        if(output[1][num]>cur.cost+1)
                            queue.add(new node(num,cur.cost+1,1));
                    }
                }
            }else{
                temp = blueMap.get(cur.n);
                if(temp!=null){
                    for(Integer num:temp){
                        if(output[0][num]>cur.cost+1)
                            queue.add(new node(num,cur.cost+1,0));
                    }
                }
            } 
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = Math.min(output[0][i],output[1][i]);
        }
        return ans;
    }
}


class node{
    public int n;
    public int cost;
    public int prevRed;
    public node(int n, int cost, int prevRed){
        this.n = n;
        this.cost = cost;
        this.prevRed = prevRed;
    }
}
