class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int curCost = 0;
        int left = 0;
        int ans = 0;
        for(int right = 0;right<n;right++){
            curCost += Math.abs(sArray[right]-tArray[right]);
            while(curCost>maxCost){
                curCost -= Math.abs(sArray[left]-tArray[left]);
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
