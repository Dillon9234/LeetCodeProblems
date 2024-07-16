class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0,j,k;
        int minSum = Integer.MAX_VALUE;
        int sum,diff ;
        while(i<n-2){
            j = i+1;
            k = n-1;
            while(j<k){
                sum = nums[i] + nums[j] + nums[k];
                diff =sum - target;
                if(sum == target)
                    return target;
                else if(Math.abs(diff)<Math.abs(minSum - target)){
                    minSum = sum;
                }
                else if(diff<0){
                    j++;
                }else{
                    k--;
                }
            }
            i++;
        }
        return minSum;
    }
}
