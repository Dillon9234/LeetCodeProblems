public class Solution {
   public int LongestOnes(int[] nums, int k)
    {
        int kcount=0,count=0, size = nums.Length;
        int maxCount=0;

        for(int i=0;i<size; i++)
        {
            if (nums[i] == 1)
                count++;
            else if(kcount<k)
            {
                count++;
                kcount++;
            }
            else
            {
                if (nums[i-count] == 1)
                {
                    count--;
                    i--;
                }
            }
            if (count > maxCount)
            {
                maxCount = count;
            }
        }
        return maxCount;

    }
}
