public class Solution
{
    int[] tribs;

    public int Tribonacci(int n)
    {
        if(n<3)
        tribs = new int[n+3];
        else{
            tribs = new int[n+1];
        }
        tribs[0] = 0;
        tribs[1]=1;
        tribs[2] = 1;
        calc(n);
        return tribs[n];
    }

    public int calc(int n)
    {
        if (n <= 2)
        {
            return tribs[n];
        }
        if (tribs[n] != 0)
        {
            return tribs[n];
        }
        else
        {
            tribs[n] = calc(n - 1) + calc(n - 2) + calc(n - 3);
            return tribs[n];
        }
    }

}
