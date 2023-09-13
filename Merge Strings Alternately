public class Solution {
    public string MergeAlternately(string word1, string word2)
    {
        string mergedWord = null;

        for (int i = 0; word1.Length != i && word2.Length != i; i++)
        {
                mergedWord += word1[i];
                mergedWord += word2[i];
        }

        mergedWord += (word1.Length > word2.Length)?word1.Substring(word2.Length,word1.Length - word2.Length):word2.Substring(word1.Length,word2.Length - word1.Length);

        return mergedWord;
    }
}
