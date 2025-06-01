class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        if(n==1){
            return nums[0];
        }
        int ans = nums[0];
        int best = nums[0];
        int worst = nums[0];

        for(int i=1;i<n;i++){
            int curP = best*nums[i];
            int curN = worst*nums[i];
            int curBest = curP>curN?curP:curN;
            int curWorst = curN>curP?curP:curN;
            if(curBest>nums[i]){
                best = curBest;
            }else{
                best = nums[i];
            }
            if(curWorst<nums[i]){
                worst = curWorst;
            }else{
                worst = nums[i];
            }
            ans = max(ans,max(best,worst));
        }
        return ans;
    }
};
