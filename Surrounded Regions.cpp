class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();
        vector<pair<int,int>> stack;
        vector<vector<bool>> visited(n, vector<bool>(m, false));     
        vector<vector<pair<int,int>>> islands;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j])
                    continue;
                if(board[i][j] == 'X'){
                    visited[i][j] = true;
                    continue;
                }
                vector<pair<int,int>> history;
                history.push_back({i,j});
                visited[i][j] = true;
                stack.push_back({i,j});
                bool flag = false;
                while(stack.size()!=0){
                    pair<int, int> cur = stack.back();
                    history.push_back({cur.first,cur.second});
                    stack.pop_back();
                    visited[cur.first][cur.second] = true;
                    if(cur.first-1>=0){
                        if(board[cur.first-1][cur.second] == 'O' && !visited[cur.first-1][cur.second])
                            stack.push_back({cur.first-1,cur.second});
                    }else{
                        flag = true;
                    }
                    if(cur.first+1<n){
                        if(board[cur.first+1][cur.second] == 'O' && !visited[cur.first+1][cur.second])
                            stack.push_back({cur.first+1,cur.second});
                    }else{
                        flag = true;
                    }
                    if(cur.second-1>=0){
                        if(board[cur.first][cur.second-1] == 'O' && !visited[cur.first][cur.second-1])
                            stack.push_back({cur.first,cur.second-1});
                    }else{
                        flag = true;
                    }
                    if(cur.second+1<m){
                        if(board[cur.first][cur.second+1] == 'O' && !visited[cur.first][cur.second+1])
                            stack.push_back({cur.first,cur.second+1});
                    }else{
                        flag = true;
                    }   
                }
                if(!flag){
                    islands.push_back(history);
                }
            }
        }
        for (int i = 0; i < islands.size(); i++) {        
            for (int j = 0; j < islands[i].size(); j++) {
                pair<int, int> p = islands[i][j];
                board[p.first][p.second] = 'X';
            }
        }

    }
};
