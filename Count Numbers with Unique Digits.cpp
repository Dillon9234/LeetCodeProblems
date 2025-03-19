class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        bool used[10] = {false};
        return helper(n,used,0);
    }

    int helper(int n, bool used[], int limit){
        if(n == limit){
            return 1;
        }
        int sum = 1;
        for(int i= (limit == 0?1:0);i<10;i++){
            if(used[i] != true){
                used[i] = true;
                sum += helper(n,used,limit+1);
                used[i] = false;
            }
        }
        return sum;
    }
};
