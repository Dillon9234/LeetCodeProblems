public class Solution {
    public string ReverseWords(string s) {
       string reverse = "",Temp;
       char[] temp;
       int index=0,prev=0,i;
       for( i = 0;i<s.Length;i++){
           if(s[i]!=' ')
           break;
       }
       Console.WriteLine(s.Remove(0,i));
       s = s.Remove(0,i);
       
       for( i = s.Length-1;i>0;i--){
           if(s[i]!=' ')
           break;
       }
       s = s.Remove(i+1);

       while(true){    
           index = s.IndexOf(' ',index+1);
           if(index == -1)
           break;
           Temp = s.Substring(prev,index - prev);
           if(Temp==""){
               prev = index+1;
               continue;
           }
           
           temp = Temp.ToCharArray();
           Array.Reverse(temp);
           //Console.WriteLine("\""+Temp+"\"");
           Temp = new string(temp);
           reverse += Temp;
           reverse += " ";
           prev = index+1;
       }
           Temp = s.Substring(prev);
           temp = Temp.ToCharArray();
           Array.Reverse(temp);
           //Console.WriteLine("\""+Temp+"\"");
           Temp = new string(temp);
           reverse += Temp;
           
        temp = reverse.ToCharArray();
        Array.Reverse(temp);
        reverse = new string(temp);

       return reverse;
       //return s;

       

    }
}

public class Solution {
    public string ReverseWords(string s) {
        int i,back=0;
        for( i = 0;i<s.Length;i++){
           if(s[i]!=' ')
           break;
       }
       s = s.Remove(0,i);
       
       for( i = s.Length-1;i>0;i--){
           if(s[i]!=' ')
           break;
       }
       s = s.Remove(i+1);

       string temp = "";
       
       for(i = 0;i<s.Length;i++){
            if(s[i]==' '&&s[i+1]==' ')
            continue;
            else
            temp+=s[i];
        }

        char[] str;
        str = temp.ToCharArray();

        for(i=1;i<str.Length;i++){

            if(str[i]==' '){
                Rev(str,back,i-back);
                back = i+1;
            }

        }

        Rev(str,back,str.Length-back);

        Rev(str,0,str.Length);

        return new string(str);


    }

    public void Rev(char[] c, int back,int length){
        char temp;
        for(int i=0;i<length/2;i++){
            temp = c[back + i];
            c[back + i]=c[back + length-i-1];
            c[back + length-i-1] = temp;
        }
    }
}
