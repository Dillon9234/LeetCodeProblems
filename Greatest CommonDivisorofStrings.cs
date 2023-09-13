public class Solution {
    public string GcdOfStrings(string str1, string str2) {
        
        int j = 0,pos=0;
        
        
        if(str2.Length >str1.Length){
            string temp = str2;
            str2 = str1;
            str1 = temp;
        }

        string test = str2;



        while(test.Length!=0){
            if(str1.Contains(test)){
                if(str1.Length%test.Length!=0 || str2.Length%test.Length!=0){
                    test = test.Remove(test.Length -1);
                    continue;
                }

                pos = str1.IndexOf(test,j*test.Length,test.Length);
                j=1;
            while(pos!=-1){

                if(j*test.Length >= str1.Length && pos !=-1){
                    //Console.WriteLine(pos);
                    break;
                }
                  //Console.Error.Write(pos+" "+j*test.Length +"\n");
                pos = str1.IndexOf(test,j*test.Length,test.Length);
                j++;
            }

            if(pos != -1){
                //    Console.Error.Write("Ans"+test+"\n");
                return test;

            }
            

            
        }else{
            return "";
        }
        
        test = test.Remove(test.Length -1);

        }
        return "";

        

    }
}
