public class Solution {
    public void MoveZeroes(int[] nums) {

        int nonZeroCount=0,size =nums.Length;
        for(int i = 0 ;i<size;i++){
            if(nums[i]!=0){
                nums[nonZeroCount]=nums[i];
                nonZeroCount++;
            }
        }

        for(int i = nonZeroCount;i<size;i++)
        nums[i]=0;
        
    }
}
