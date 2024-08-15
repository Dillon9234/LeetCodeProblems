class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] nearest = new int[32];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<32;j++){
                if((nums[i] & (1<<j))>0){
                    nearest[j] = i;
                }
            }

            int last = i;

            for(int j=0;j<32;j++){
                last = Math.max(nearest[j],last);
            }
            ans[i] = last-i+1;
        }

        return ans;
    }
}
