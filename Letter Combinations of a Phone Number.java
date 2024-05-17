import java.util.ArrayList;
import java.util.List;

class Solution {

    char Encoded[][] = {{'a','b','c'},{'d','e','f'},
    {'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'}
    ,{'t','u','v'},{'w','x','y','z'}};

    List<String> ans;
    int len;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        len = digits.length();
        if(len == 0)
            return ans;
        myFn("", digits, 0);
        return ans;
    }
    private void myFn(String str,String digits, int pos){
        if(pos==len){
            ans.add(str);
            return;
        }

        int cur = digits.charAt(pos) - '2';
        for(int i=0; i<3; i++){
            myFn(str + Encoded[cur][i], digits, pos+1);
        }
        if(cur == 5)
            myFn(str + Encoded[5][3], digits, pos+1);
        else if(cur == 7)
            myFn(str + Encoded[7][3], digits, pos+1);
    }
}
