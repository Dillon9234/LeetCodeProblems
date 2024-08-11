class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        int[] cur = new int[26];
        int n = s1.length();
        int m = s2.length();

        for(int i=0;i<n;i++){
            map[s1.charAt(i) - 'a']++;
        }

        int size = 1;
        int left= 0;

        for(int right =0;right<m;right++){
            cur[s2.charAt(right) - 'a']++;
            if(right-left+1 == n){
                if(check(map,cur))
                    return true;
                cur[s2.charAt(left++) - 'a']--;
            }
            
        }
        return false;
    }

    private boolean check(int[] map, int[] cur){
        for(int i=0;i<26;i++){
            if(map[i]-cur[i]!=0)
                return false;
        }
        return true;
    }
}
