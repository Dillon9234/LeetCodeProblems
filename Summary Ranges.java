class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();
        int n = nums.length;
        int left = 0;
        int i;
        if(n == 0)
            return output;
        for(i=0;i<n-1;i++){
            if(nums[i]+1 != nums[i+1]){
                StringBuilder str = new StringBuilder();
                if(i - left !=0){
                    str.append(nums[left]).append("->").append(nums[i]);
                }else{
                    str.append(nums[left]);
                }
                left = i+1;
                output.add(str.toString());
            }
        }
        StringBuilder str = new StringBuilder();
        if(i - left !=0){
            str.append(nums[left]).append("->").append(nums[i]);
        }else{
            str.append(nums[left]);
        }
        output.add(str.toString());
        return output;
    }
}
