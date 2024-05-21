import java.util.HashMap;

class Solution {
    HashMap<Character,Integer> hashMap;
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n)
            return "";

        HashMap<Character,Integer> Freq = new HashMap<>();
        int ptr1 = 0;
        int ptr2 = 0;
        int min = Integer.MAX_VALUE;
        int minptr1=0;
        char temp;
        int count = m;

        for(int i =0;i<m;i++){
            temp = t.charAt(i);
            Freq.put(temp, Freq.getOrDefault(temp, 0)+1);
        }
        boolean changed = true;
        while(ptr2<n){
            
            if(changed){
                temp = s.charAt(ptr2);
                if(Freq.containsKey(temp)){
                    if(Freq.getOrDefault(temp,0)>0){
                        count--;
                    }
                    Freq.replace(temp, Freq.get(temp)-1);
                }
            }
            changed = false;
            if(count == 0){
                if(ptr2-ptr1<min){
                    min = ptr2-ptr1;
                    minptr1 = ptr1;
                }
                temp = s.charAt(ptr1);
                ptr1++;
                if(Freq.containsKey(temp)){
                    if(Freq.get(temp)==0)
                        count++;
                    Freq.replace(temp, Freq.get(temp)+1);
                }
            }else{
                ptr2++;
                changed =true;   
            } 
        }
        String ans = new String();
        if(min!= Integer.MAX_VALUE)
            ans = s.substring(minptr1, minptr1+min+1);
        return ans;
    }
}
