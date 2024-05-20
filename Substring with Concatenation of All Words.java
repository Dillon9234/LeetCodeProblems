//Not the most efficient


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> hashmap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int len = words.length;
        int wordLen = words[0].length();
        int strLen = s.length();
        for(int j = 0; j<strLen - len * wordLen + 1;j++){
            for(int i = 0; i<len;i++){
                Integer temp = hashmap.get(words[i]);
                if(temp == null)
                    hashmap.put(words[i],1);
                else
                    hashmap.replace(words[i],temp+1);
            }
            String str = "";
            str = s.substring(j, j + wordLen);
            int k = 1;
            
            while(hashmap.containsKey(str)){
                Integer temp = hashmap.get(str);
                if(temp == 1)
                    hashmap.remove(str);
                else
                    hashmap.replace(str,temp-1);
                if(hashmap.isEmpty()){
                    ans.add(j);
                    break;
                }
                str = "";
                if(j+(k+1)*wordLen>strLen)
                    break;
                str = s.substring(j+k*wordLen, j+(k+1)*wordLen);
                
                k++;
            }
            hashmap.clear();
        }
        return ans;
    }
}
