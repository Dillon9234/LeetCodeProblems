class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lengths = new int[n];
        Arrays.fill(lengths,1);
        int max = 1;
        int temp,temp1;
        for(int i = n-2; i>=0 ;i--){
            for(int j = i+1;j<n-1;j++){
                if(lengths[j]>lengths[j+1])
                    break;
                temp = nums[j];
                temp1 = lengths[j];
                lengths[j] = lengths[j+1];
                nums[j] = nums[j+1];
                lengths[j+1] = temp1;
                nums[j+1] = temp;
            }
            for(int j = i+1;j<n;j++){
                if(nums[j]>nums[i]){
                    lengths[i] = lengths[j]+1;
                    max = Math.max(max, lengths[i]);
                    break;
                }
            }
        }
        return max;
    }
}
