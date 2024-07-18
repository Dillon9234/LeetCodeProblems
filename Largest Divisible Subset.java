class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        int curMax;
        int temp;
        if(n == 1){
            output.add(nums[0]);
            return output;
        }
        int[][] dp = new int[2][n];
        int maxPtr = 0;
        int max = 1;

        for(int i = n-1;i>=0;i--){
            dp[1][i] = 1;
            dp[0][i] = -1;
            curMax = 1;
            for(int j = i+1;j<n;j++){
                temp = 1;
                if(nums[j]%nums[i]==0){
                    temp = dp[1][j]+1;
                }
                if(curMax<temp){
                    curMax = temp;
                    dp[0][i] = j;
                    dp[1][i] = temp;
                }
            }
            if(curMax>max){
                max = curMax;
                maxPtr = i;
            }
        }
        int i = maxPtr;
        
        while(true){
            if(i == -1)
                break;
            output.add(nums[i]);
            i = dp[0][i];
        }
        return output;
    }
}
