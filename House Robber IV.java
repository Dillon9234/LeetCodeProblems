class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = Integer.MAX_VALUE;
        int mid,cur;
        while(left<right){
            mid = (left+right)/2;
            cur = 0;
            for(int i=0;i<n;i++){
                if(nums[i]<=mid){
                    cur++;
                    i++;
                }
            }
            if(cur>=k)
                right = mid;
            else
                left = mid + 1;
            
        }
        return left;
    }
}
