class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        HashMap<String,Integer> dp= new HashMap<>();
        return helper(dp, nums, target, len-1, 0);
    }

    public int helper(HashMap<String,Integer> dp, int[] nums,int target,int index,int cur){
        String test = index + "," + cur;
        if(dp.containsKey(test)){
            return dp.get(test);
        }
        if(index<0 && cur == target){
            return 1;
        }
        if(index<0){
            return 0;
        }

        int add = helper(dp,nums,target,index-1,cur + nums[index]);
        int substract = helper(dp,nums,target,index-1,cur - nums[index]);

        dp.put(test,add + substract);
        return add + substract;
    }
}
