public class Solution {
    public int MaxOperations(int[] nums, int k) {
        int count = 0,front=0,rear=nums.Length-1;
        Array.Sort(nums);

        while(rear>front){
            int sum = nums[front]+nums[rear];
            if(sum==k){
                count++;
                front++;
                rear--;
            }
            else if(sum<k){
                front++;                
            }
            else{
                rear--;
            }
        }

        return count;

         

    }
}
