class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int n = s.length();
        int index = 0;
        int diff = 1;
        List<StringBuilder> stringBuilderList = new ArrayList<>();
        for(int i=0;i<numRows;i++)
            stringBuilderList.add(new StringBuilder());
        for(int i=0;i<n;i++){
            stringBuilderList.get(index).append(s.charAt(i));
            if(index + 1 >= numRows){
                diff = -1;
            }
            else if(index - 1 <0){
                diff = 1;
            }
            index += diff;
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder str: stringBuilderList){
            ans.append(str);
        }
        return ans.toString();
    }
}
