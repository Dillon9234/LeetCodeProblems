public class Solution {
    public int MaxVowels(string s, int k)
    {
        int size = s.Length;
        int max = 0, sum = 0;
        if (s.Length < k)
            return 0;
        for(int i = 0; i < k; i++)
        {
            if (isVowel(s[i]))
            {
                max++;
            }
        }
        sum = max;
        for(int i = k; i < size; i++)
        {
            if (isVowel(s[i]))
            {
                    sum++;
            }
            if (isVowel(s[i - k]))
            {
                sum--;
            }
            if (sum > max)
                max = sum;
        }
        return max;
    }
    bool isVowel(char c)
    {
        switch(c)
        {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':return true;
            default: return false;

        }
    }
}
