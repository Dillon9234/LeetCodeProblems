class Solution {
    int[] parent;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        for(String str:equations){
            if(str.charAt(1)=='!')
                continue;
            union(str.charAt(0) - 97,str.charAt(3) - 97);
        } 

        for(String str:equations){
            if(str.charAt(1)!='!')
                continue;
            if(find(str.charAt(0) - 97) == find(str.charAt(3) - 97))
                return false;
        } 
        return true;
    }

    private int find(int x){
        if(parent[x] == x)
            return x;
        return find(parent[x]);
    }

    private void union(int a, int b){
        parent[find(b)] = find(a);
    }
}
