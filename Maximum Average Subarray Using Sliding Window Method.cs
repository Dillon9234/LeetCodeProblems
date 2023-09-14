public class Solution {
    public double FindMaxAverage(int[] nums, int k) {
        int size = nums.Length;
        double sum = 0, Max = 0;
        if (size < k)
            return 0;
        else
        for (int j = 0; j < k; j++)
        {
            sum += nums[j];
        }
        Max = sum;
        for (int i = k; i< size; i++)
        {
            sum += nums[i] - nums[i - k];
            if(sum>Max)
                Max = sum;
        }
        return Max/k;

    }
}
