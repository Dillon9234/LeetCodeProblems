class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int prev = nums[0];
        int ans = prev;
        for(int i=1;i<n;i++){
            prev = max(prev+nums[i],nums[i]);
            ans = max(prev,ans);
        }
        return ans;
    }
};
