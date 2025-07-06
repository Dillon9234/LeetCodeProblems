public class Node {
    int number;
    int cost;

    public Node(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }
}


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int adj[][] = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(adj[i], -1);
        }
        for(int i=0;i<times.length;i++){
            adj[times[i][0]][times[i][1]] = times[i][2];
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.cost, b.cost)
        );
        HashSet<Integer> set = new HashSet<>();

        pq.add(new Node(k,0));
        int cost = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(set.contains(cur.number))
                continue;
            cost = cur.cost;
            set.add(cur.number);
            for(int i=1;i<=n;i++){
                if(adj[cur.number][i]!=-1 && !set.contains(i)){
                    pq.add(new Node(i,adj[cur.number][i]+cost));
                }
            }
        }

        if(set.size() == n)
            return cost;
        else
            return -1;
    }
}
