class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int[][] count = new int[2][2];

        char[] string = s.toCharArray();

        for(int i=0;i<n;i++){
            count[string[i]-'0'][i%2]++;
        }
        int ans = count[1][0] + count[0][1]; //0 even, 1 odd
        ans = Math.min(ans,count[0][0]+count[1][1]);//1 even, 0 odd

        for(int i=0;i<n;i++){
            count[string[i]-'0'][i%2]--;
            count[string[i]-'0'][(n+i)%2]++;
            ans = Math.min(ans,count[1][0]+count[0][1]);//0 even, 1 odd
            ans = Math.min(ans,count[0][0]+count[1][1]);//1 even, 0 odd
        }
        return ans;
    }
}
