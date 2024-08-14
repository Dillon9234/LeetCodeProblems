class Solution {
    public int balancedString(String s) {
        int[] map = new int[128];

        int n = s.length();
        int goal = n/4;
    
        for(int i=0;i<n;i++){
            map[s.charAt(i)]++;
        }
        int output = n;
        int left = 0;
        for(int right = 0;right<n;right++){
            map[s.charAt(right)]--;
            while(left<n && map['Q']<=goal && map['W']<=goal && map['E']<=goal && map['R']<=goal ){
                output = Math.min(output,right-left+1);
                map[s.charAt(left++)]++;
            }   
        }

        return output;
    }

}
