class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(m>n){
            return ans;
        }
        int[] pMap = new int[26];
        int[] map = new int[26];
        for(int i=0;i<m;i++){
            pMap[p.charAt(i)-'a']++;
            map[s.charAt(i)-'a']++;
        }
        if(check(map,pMap)){
            ans.add(0);
        }
        int left = 0;
        int right = m;

        while(right<n){
            map[s.charAt(left++)-'a']--;
            map[s.charAt(right++)-'a']++;
            if(check(map,pMap)){
                ans.add(left);
            }
        }
        return ans;
    }

    private boolean check(int[] map,int[] nMap){
        for(int i=0;i<26;i++){
            if(map[i]!=nMap[i])
                return false;
        }
        return true;
    }
}
