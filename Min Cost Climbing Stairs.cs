public class Solution
{
    public int MinCostClimbingStairs(int[] cost)
    {
        int size = cost.Length;
        for(int i = 2; i < size; i++)
        {
            cost[i] += Math.Min(cost[i - 1], cost[i-2]);
        }

        return Math.Min(cost[size - 1], cost[size - 2]);
    }

}
