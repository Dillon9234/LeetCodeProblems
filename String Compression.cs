public class Solution {
    public int Compress(char[] chars) {
      string ans="";
      int size = chars.Length;
      int count,i;
      char current;
      for(i = 0;i<size;){
         current = chars[i];
         count = 0;
         for(int j = i;j<size;j++){
            if(current == chars[j]){
                count++;
            }else break;
         }
         if(count==1){
            ans+=chars[i++];
         }else{
            ans+=chars[i];
            ans += count.ToString();
            i+=count;
            }
            
         }
      int k=0;
      foreach(char element in ans){
          chars[k++]=element;
      }
      return ans.Length;


    }
}
