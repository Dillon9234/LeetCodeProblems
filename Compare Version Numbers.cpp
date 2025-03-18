class Solution {
public:
    int compareVersion(string version1, string version2) {
        int n = version1.length();
        int m = version2.length();

        int ptr11 = 0;
        int ptr12 = 0;
        int ptr21 = 0;
        int ptr22 = 0;
        int num1 = 0;
        int num2 = 0;

        while(ptr12<n || ptr22<m){
            num1=0;
            num2=0;
            while(ptr12<n && version1[ptr12] != '.'){
                ptr12++;
            }
            while(ptr22<m && version2[ptr22] != '.'){
                ptr22++;
            }
            if(ptr11 <n)
                num1 = stoi(version1.substr(ptr11,ptr12-ptr11+1));
            if(ptr21 <m)
                num2 = stoi(version2.substr(ptr21,ptr22-ptr21+1));
            if(num1 == num2){
                ptr11 = ++ptr12;
                ptr21 = ++ptr22;
            }else if(num1>num2){
                return 1;
            }else
                return -1;
        }

        return 0;
    }
};
