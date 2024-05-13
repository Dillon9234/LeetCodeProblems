class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i=0,j=1;
        while(j<len){
            if(nums[i] == nums[j])
                j++;
            else
                nums[++i] = nums[j++];
        }
        return i+1;
    }
}
