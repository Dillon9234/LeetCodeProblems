class Solution {
public:
    int size;
    bool helper(string& num, long prev, long mid,int end, int n){
        if(end+n>size){
            return false;
        }
        long equals = stol(num.substr(end,n));
        if((n==1 || num[end]!='0') && (prev+mid==equals)){
            if(end+n == num.length())
                return true;
            return helper(num,mid,equals,end+n,1);
        }
        if(prev+mid<equals)
            return false;
        if(helper(num,prev,mid,end,n+1))
            return true;
        return false;
    }

    bool isAdditiveNumber(string num) {
        size = num.length();
        for(int i=1;i<=size/2;i++){
            for(int j=1;j<=(size-i)/2;j++){
                if(i!=1 && num[0] == '0')
                    continue;
                if(j!=1 && num[i] == '0')
                    continue;
                if(helper(num,stol(num.substr(0,i)),stol(num.substr(i,j)),i+j,1))
                    return true;
            }
            
        }
        return false;
    }
};
