class Solution {
    public String intToRoman(int num) {
        int[] divisors = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<13;i++){
            while(num>=divisors[i]){
                num -= divisors[i];
                ans.append(symbols[i]);
            }
        }
        return ans.toString();
    }
}
