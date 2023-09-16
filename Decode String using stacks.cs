public class Solution
{
    public string DecodeString(string s)
    {
        string output = "";       
        Stack<char> stack = new Stack<char>();  

        for(int i = s.Length-1; i>=0; i--)
            stack.Push(s[i]);

        while(stack.Count > 0)
        {
            char element = stack.Pop();
            if(!char.IsDigit(element)) {
            output += element;
            }
            else
            {
                string nums = "";
                while (element != '[')
                {
                    nums += element;
                    element = stack.Pop();
                }
                int count = Int32.Parse(nums);
                string word = nums;
                word = "";
                int bracketCount = 1;
                while(bracketCount > 0) {
                    element = stack.Pop();
                    if (element == '[')
                    {
                        bracketCount++;
                        word += element;
                    }
                    else if (element == ']')
                    {
                        bracketCount--;
                        word += element;
                    }
                    else
                        word += element;
                }
                word = word.Substring(0,word.Length-1);
                while (count > 0)
                {
                    for (int i = word.Length - 1; i >= 0; i--)
                    {
                        stack.Push(word[i]);
                    }
                    count--;
                }
                
            }
        }


        return output;
    }
}
