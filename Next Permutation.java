class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int k = n-2, l = n-1;

        while(k>=0 && nums[k]>=nums[k+1]){
            k--;
        }
        if(k == -1){
            for(int i = 0;i<n/2;i++){
                nums[i] += nums[n-i-1];
                nums[n-i-1] = nums[i] - nums[n-i-1];
                nums[i] -= nums[n-i-1];
            }
            return;
        }
        while(nums[k]>=nums[l]){
            l--;
        }
        nums[k] += nums[l];
        nums[l] = nums[k] - nums[l];
        nums[k] -=  nums[l];
        for(int i = k+1;i<(n+k+1)/2;i++){
            nums[i] += nums[n+k-i];
            nums[n+k-i] = nums[i] - nums[n+k-i];
            nums[i] -= nums[n+k-i];
        }
    }
}
