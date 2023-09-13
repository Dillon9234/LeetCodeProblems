public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        int size = nums.Length;
        int i,temp=1;
        int[] answer = new int[size];
        
        for(i = 0;i<size;i++){
            answer[i]=temp;
            temp*=nums[i];
        }
        temp=nums[size-1];

        for(i = size-2;i>=0;i--){
            answer[i]*=temp;
            temp*=nums[i];
        }

        return answer;
        
    }
}
