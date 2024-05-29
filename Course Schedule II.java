class Solution {
    List<List<Integer>> graph;
    int n;
    boolean[] visited;
    boolean[] curPath;
    Stack<Integer> stack;
    private boolean DFS(int node){
        if(curPath[node])
            return false;
        if(visited[node] == true)
            return true;
        curPath[node] = true;
        visited[node] = true;
        for (Integer cur : graph.get(node)) {
            if(!DFS(cur))
                return false;
        }
        stack.push(node);
        curPath[node] = false;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        graph = new ArrayList<>();
        for(int i =0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());
        visited = new boolean[numCourses];
        for (int[] cur : prerequisites)
            graph.get(cur[1]).add(cur[0]);
        curPath = new boolean[numCourses];
        stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(!visited[i]&&!DFS(i))
                return new int[0];
        }

        int[] ans = new int[numCourses];
        for(int i = 0;i<n;i++){
            ans[i] = stack.pop();
        }
        return ans;
    }
}
