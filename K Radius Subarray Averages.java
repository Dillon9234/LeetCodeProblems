class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        if(n<=2*k){
            for(int i=0;i<n;i++)
                ans[i] = -1;
            return ans;
        }

        for(int i=0;i<k;i++){
            ans[i] = -1;
        }
        long sum = 0;
        for(int i=0;i<=2*k;i++){
            sum += nums[i];
        }
        ans[(2*k)/2] = (int)(sum/(2*k+1));
        int left = 1;
        int right = 2*k+1;
        int mid = (left+right)/2;
        while(right<n){
            mid = (left+right)/2;
            
            sum -= nums[left-1];
            sum += nums[right];
            ans[mid] = (int)(sum/(2*k+1));
            left++;
            right++;
        }
        for(int i= n-k;i<n;i++){
            ans[i] = -1;
        }
        return ans;
    }
}
