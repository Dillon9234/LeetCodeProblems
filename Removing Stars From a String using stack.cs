public class Solution {
    public string RemoveStars(string s)
    {
        Stack<char> stack = new Stack<char>();
        int size = s.Length;

        for(int i = 0; i < size; i++)
        {
            if (s[i] == '*')
            {
                stack.Pop();
            }
            else
            {
                stack.Push(s[i]);
            }
        }
        return new string(stack.Reverse().ToArray());
    }
}
