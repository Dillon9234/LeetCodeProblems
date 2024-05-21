class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int cur = nums[0];

        while(true){
            if(cur >= target){
                if(right-left+1<min){
                    min = right-left+1;
                }
                cur -= nums[left++];
            }
            else{
                if(right+1 == n)
                    break;
                cur += nums[++right];
            }
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}
