class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        int passengers = 0;
        int n = trips.size();
        auto cmp = [](const std::pair<int, int>& a, const std::pair<int, int>& b) { 
        return a.second > b.second;
        };

        std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, decltype(cmp)> minPQ(cmp);

        std::sort(trips.begin(), trips.end(), [](const std::vector<int>& a, const std::vector<int>& b) {
            return a[1] < b[1];
        });
        for(int i=0;i<n;i++){
            while(!minPQ.empty() && minPQ.top().second<=trips[i][1]){
                passengers -= minPQ.top().first;
                minPQ.pop();
            }
            if(trips[i][0] + passengers > capacity)
                return false;

            minPQ.push({trips[i][0], trips[i][2]});
            passengers += trips[i][0];
        }
        return true;
    }
};
