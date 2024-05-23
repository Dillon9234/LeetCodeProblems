class Solution {
    int n;
    String s;
    HashSet<String> Dict;
    HashSet<Integer> sizes;
    Boolean[] remainingReached;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = wordDict.size();
        int m = s.length();
        this.s = s;
        Dict = new HashSet<>(wordDict);
        sizes = new HashSet<>();
        remainingReached = new Boolean[m+1];
        for(int i =0;i<n;i++)
            sizes.add(wordDict.get(i).length());
        return helper(m, 0);
    }

    private boolean helper(int remaining, int pos){
        if(remaining == 0)
            return true;
        if(remainingReached[remaining]!=null)
            return remainingReached[remaining];
        int temp;
        String cur;
        for (Integer len : sizes) {
            temp = remaining - len;
            if(temp<0)
                continue;
            cur = s.substring(pos, pos+len);
            if(Dict.contains(cur)&&helper(temp, pos+len)){
                remainingReached[remaining] = true;
                return true;
            }
        }
        remainingReached[remaining] = false;
        return false;
    }
}
