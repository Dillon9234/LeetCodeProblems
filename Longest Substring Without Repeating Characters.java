import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        int max = 1;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        boolean test;
        while(right<n){
            test = set.add(s.charAt(right));
            if(test){
                if(right-left+1>max)
                    max = right-left+1;
                right++;
            }else
                set.remove(s.charAt(left++));      
        }
        return max;
    }
}
