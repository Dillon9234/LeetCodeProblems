class Solution {
    HashMap<Integer, String> numberMap;
    public String numberToWords(int num) {

        if(num == 0)
            return "Zero";
        numberMap = new HashMap<>();
        StringBuilder output = new StringBuilder();

        numberMap.put(0, "");
        numberMap.put(1, "One");
        numberMap.put(2, "Two");
        numberMap.put(3, "Three");
        numberMap.put(4, "Four");
        numberMap.put(5, "Five");
        numberMap.put(6, "Six");
        numberMap.put(7, "Seven");
        numberMap.put(8, "Eight");
        numberMap.put(9, "Nine");
        numberMap.put(10, "Ten");
        numberMap.put(11, "Eleven");
        numberMap.put(12, "Twelve");
        numberMap.put(13, "Thirteen");
        numberMap.put(14, "Fourteen");
        numberMap.put(15, "Fifteen");
        numberMap.put(16, "Sixteen");
        numberMap.put(17, "Seventeen");
        numberMap.put(18, "Eighteen");
        numberMap.put(19, "Nineteen");
        numberMap.put(20, "Twenty");
        numberMap.put(30, "Thirty");
        numberMap.put(40, "Forty");
        numberMap.put(50, "Fifty");
        numberMap.put(60, "Sixty");
        numberMap.put(70, "Seventy");
        numberMap.put(80, "Eighty");
        numberMap.put(90, "Ninety");
        numberMap.put(100, "Hundred");
        numberMap.put(1000, "Thousand");
        numberMap.put(1000000, "Million");
        numberMap.put(1000000000, "Billion");

        int cur;
        cur = num/1000000000;
        if(cur!=0){
            output.append(numberMap.get(cur));
            output.append(" ");
            output.append(numberMap.get(1000000000));
        }
        cur = (num/1000000)%1000;
        if(cur!=0){
            output.append(" ");
            output.append(threeConvert(cur));
            output.append(" ");
            output.append(numberMap.get(1000000));
        }
        cur = (num/1000)%1000;
        if(cur!=0){
            output.append(" ");
            output.append(threeConvert(cur));
            output.append(" ");
            output.append(numberMap.get(1000));
        }
        cur = num%1000;
        if(cur!=0){
            output.append(" ");
            output.append(threeConvert(num%1000));
        }
        
        return output.toString().trim();

    }

    private String threeConvert(int nums){
        int cur;
        StringBuilder ans = new StringBuilder();

        cur = nums/100;
        if(cur!=0){
            ans.append(numberMap.get(cur));
            ans.append(" ");
            ans.append(numberMap.get(100));
            ans.append(" ");
        }

        cur = nums%100;
        if(numberMap.containsKey(cur)){
            ans.append(numberMap.get(cur));
            ans.append(" ");
        }else{
            cur = (nums%100)/10;
            if(cur!=0){
                ans.append(numberMap.get(cur*10));
                ans.append(" ");
            }
            cur = nums%10;
            ans.append(numberMap.get(cur));
            ans.append(" ");
        }
        
        return ans.toString().trim();
    }
}
