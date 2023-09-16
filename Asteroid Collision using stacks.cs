public class Solution
{
    public int[] AsteroidCollision(int[] asteroids)
    {
        Stack<int> stack = new Stack<int>();
        int size = asteroids.Length;

        for (int i = 0; i < size; i++)
        {
            if (asteroids[i] > 0)
            {
                stack.Push(asteroids[i]);
                continue;
            }
            stack.Push(asteroids[i]);
            int e1;
            int e2;

            while (stack.Count > 1)
            {
                e1 = stack.Pop();
                e2 = stack.Pop();

                if (e1 < 0 && e2 > 0)
                {
                    if (e2 == -e1)
                        continue;
                    else
                    {
                        stack.Push(e2 > -e1 ? e2 : e1);
                    }
                }
                else
                {
                    stack.Push(e2);
                    stack.Push(e1);
                    break;
                }
            }

        }


        return stack.Reverse().ToArray();
    }
}
