public class Solution
{
    public bool UniqueOccurrences(int[] arr)
    {
        Dictionary<int,int> dics = new Dictionary<int,int>();

        foreach (int i in arr)
        {
            if (dics.ContainsKey(i))
            {
                dics[i]++;
            }
            else
                dics.Add(i, 1);
        }

        HashSet<int> Vals = new HashSet<int>(dics.Values);
        if(dics.Count == Vals.Count)
        {
            return true;
        }else
            return false;

    }
}
