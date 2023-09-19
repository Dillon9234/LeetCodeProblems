public class Solution
{
    Queue<int> Dire = new Queue<int>();
    Queue<int> Radiant = new Queue<int>();


    public string PredictPartyVictory(string senate)
    {
        int n=0;
        foreach (char c in senate)
        {
            if(c=='R')
                Radiant.Enqueue(n++);
            else
                Dire.Enqueue(n++);
        }

        while(Radiant.Count > 0 && Dire.Count > 0)
        {
            int r = Radiant.Dequeue();
            int d = Dire.Dequeue();
            if (r < d)
            {
                Radiant.Enqueue(n++);
            }
            else
            {
                Dire.Enqueue(n++);
            }
        }

        return Radiant.Count == 0 ? "Dire" : "Radiant";
    }
}
