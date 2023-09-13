public class Solution {
    public bool IsSubsequence(string s, string t) {
        
        int sL = s.Length;
        int tL = t.Length;
        int count = 0;
        bool present;

        if(sL==0)
        return true;


        for(int i=0;i<tL&&count<sL;i++){
            if(t[i]==s[count])
            count++;
            
        }
        return sL==count;
        
    }
}
