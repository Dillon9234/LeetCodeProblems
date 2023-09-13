public class Solution {
    public string ReverseVowels(string s) {
        int i=0,j=s.Length-1;
        char temp;
        char[] ans =s.ToCharArray();
        while(i<j){
          if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'||s[i]=='A'||s[i]=='E'||s[i]=='I'||s[i]=='O'||s[i]=='U'){
              if(s[j]=='a'||s[j]=='e'||s[j]=='i'||s[j]=='o'||s[j]=='u'||s[j]=='A'||s[j]=='E'||s[j]=='I'||s[j]=='O'||s[j]=='U'){
                  temp = ans[i];
                  ans[i] = ans[j];
                  ans[j] = temp;
                  i++;
                  j--;
              }else{
                  j--;
              }
          }else{
              i++;
          }
        }
        string str = new string(ans);
        return str;
        
    }
}
