public class Solution
{
    public int EqualPairs(int[][] grid)
    {
        int n = grid.GetLength(0);
        Dictionary<String, int> map = new Dictionary<String, int>();
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            string s = "";
            for (int j = 0; j < n; j++)
            {
                s+=grid[i][j]+" ";
            }
            if (map.ContainsKey(s))
            {
                map[s]++;
            }
            else
            {
                map.Add(s, 1);
            }
        }

        for (int i = 0; i < n; i++)
        {
            string s = "";
            for (int j = 0; j < n; j++)
            {
                s += grid[j][i] + " ";
            }
            if (map.ContainsKey(s))
            {
                count += map[s];
            }
        } 
        
        return count;
    }
}
