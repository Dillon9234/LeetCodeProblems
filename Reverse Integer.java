class Solution {
    public int reverse(int x) {
        long ans = 0;
        long rem;
        while(x!=0){
            rem = x%10;
            x /= 10;
            ans = ans*10 +rem;
        }
        if(ans>Math.pow(2,31) - 1)
            return 0;
        else if(-Math.abs(ans)<-Math.pow(2,31))
            return 0;
        return (int)ans;
    }
}
