public class Solution
{
    public IList<IList<int>> FindDifference(int[] nums1, int[] nums2)
    {
        HashSet<int> n1 = new HashSet<int>(nums1);
        HashSet<int> n2 = new HashSet<int>(nums2);

        IList<IList<int>> result = new List<IList<int>>();
        List<int> temp = new List<int>();
        foreach(int i in n1)
        {
            if(!n2.Contains(i)) {
                temp.Add(i);
            }
        }
        result.Add(temp);
        temp= new List<int>();
        foreach (int i in n2)
        {
            if (!n1.Contains(i))
            {
                temp.Add(i);
            }
        }
        result.Add(temp);
        return result;
    }
}
