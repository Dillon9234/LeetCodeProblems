class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0)
            return 0;
        if(k<2)
            return s.length();
        return helper(s,0,s.length(),k);   
    }

    private int helper(String s, int left, int right, int k){
        if(left>=right)
            return 0;
        int[] map = new int[26];
        for(int i=left;i<right;i++){
            map[s.charAt(i)-'a']++;
        }
        boolean flag = true;
        for(int i=0;i<26 && flag; i++){
            if(map[i]>0 && map[i]<k){
                flag = false;
            }
        }
        if(flag)
            return right-left;
        int max =0, start = left;
        for(int i=left;i<right;i++){
            if(map[s.charAt(i)-'a']<k ){
                max = Math.max(max,helper(s,start,i,k));
                start = i+1;
            }
        }
        max = Math.max(max,helper(s,start,right,k));
        return max;
    }
}
