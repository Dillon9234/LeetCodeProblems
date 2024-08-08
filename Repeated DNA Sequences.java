class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> output = new HashSet<>();
        HashSet<String> history = new HashSet<>();
        List<String> ans = new ArrayList<>();
        if(n<10)
            return ans;
        int left = 0;
        String cur;
        while(left<=n-10){
            cur = s.substring(left,left+10);
            if(!history.add(cur)){
                output.add(cur);
            }
            left++;
        }
       
        ans.addAll(output);
        return ans;
    }
}
