public class Solution {
    public int LongestSubarray(int[] nums)
    {
        int right = 0, left = 0, maxCount = 0, size = nums.Length;
        bool deleted = false;
        while (right >= left && right<size) {
            if (nums[right] == 1)
                right++;
            else if (!deleted)
            {
                deleted = true;
                right++;
            }
            else if (nums[left] == 1)
            {
                left++;
            }
            else
            {
                deleted = false;
                left++;
            }
            if (right-left-1 > maxCount)
            {
                maxCount = right - left - 1;
            }
        }
        return maxCount;

    }
}
