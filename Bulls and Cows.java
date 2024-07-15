class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = secret.length();
        int bulls=0,cows = 0;
        List<Character> PossibleCows = new ArrayList<>(); 
        for(int i=0;i<n;i++){
            char cur = secret.charAt(i);
            if(cur == guess.charAt(i))
                bulls++;
            else{
                PossibleCows.add(guess.charAt(i));
                map.put(cur,map.getOrDefault(cur,0)+1);
            }
        }

        for(Character c:PossibleCows){
            Integer cur = map.get(c);
            if(cur==null){
                continue;
            }
            cows++;
            if(cur == 1){
                map.remove(c);
            }else{
                map.put(c,cur-1);
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(bulls);
        ans.append('A');
        ans.append(cows);
        ans.append('B');
        return ans.toString();
    }
}
