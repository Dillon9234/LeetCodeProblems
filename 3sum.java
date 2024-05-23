class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i,j,k;
        int sum;        
        int  target;
        List<List<Integer>> ans = new ArrayList<>();
        for(i=0;i<n-2;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            if(nums[i]>0)
                break;
            j = i+1;
            k = n-1;
            while(j<k){
                if(nums[k]<0)
                    break;
                sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k){
                        if(nums[j]!=nums[j-1])
                            break;
                        j++;
                    }
                    while(j<k){
                        if(nums[k]!=nums[k+1]||nums[k]<0)
                            break;
                        k--;
                    }
                }else if(sum<0)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }
}
