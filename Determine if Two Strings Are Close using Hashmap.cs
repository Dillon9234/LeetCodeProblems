public class Solution
{
    public bool CloseStrings(string word1, string word2)
    {

        if(word1.Length != word2.Length)
            return false;


        Dictionary<char, int> dict1 = new Dictionary<char, int>();

        foreach (char c in word1)
        {
            if (dict1.ContainsKey(c))
            {
                dict1[c]++;
            }
            else
                dict1.Add(c, 1);
        }

        Dictionary<char, int> dict2 = new Dictionary<char, int>();

        foreach (char c in word2)
        {
            if (dict2.ContainsKey(c))
            {
                dict2[c]++;
            }
            else
                dict2.Add(c, 1);
        }

        foreach (char k in dict1.Keys)
        {
            if (!dict2.ContainsKey(k))
                return false;
        }


        Dictionary<int, int> c1 = new Dictionary<int, int>();
        foreach (int i in dict1.Values)
        {
            if(c1.ContainsKey(i))
            {
                c1[i]++;
            }else
                c1.Add(i, 1);
        }

       

        Dictionary<int, int> c2 = new Dictionary<int, int>();
        foreach (int i in dict2.Values)
        {
            if (c2.ContainsKey(i))
            {
                c2[i]++;
            }
            else
                c2.Add(i, 1);
        }

        foreach(int k in c1.Keys)
        {
            if (!c2.ContainsKey(k))
                return false;
        }

        foreach(int k in c1.Keys)
        {
            if (c1[k] != c2[k]) return false;
        }

        return true;
    }
}
