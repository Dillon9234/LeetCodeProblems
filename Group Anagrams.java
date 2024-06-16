class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] cur = string.toCharArray();
            Arrays.sort(cur);
            String curStr = new String(cur);
            if(!map.containsKey(curStr)){
                map.put(curStr,new ArrayList<>());
            }
            map.get(curStr).add(string);
        }
        return new ArrayList<>(map.values());
    }
}
