public class Solution
{
    public int Rob(int[] nums)
    {
        int size = nums.Length;
        if(size<3){
            return nums.Max();
        }
        

        nums[2]+=nums[0];
        for(int i = 3; i < size; i++)
        {
            nums[i] += Math.Max(nums[i-2],nums[i-3]);
        }

        return Math.Max(nums[size -1 ], nums[size - 2]);

    }
}
