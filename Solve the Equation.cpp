class Solution {
public:
    string solveEquation(string equation) {
        int coef = 0;
        int intercept = 0;
        int n = equation.length();
        bool isLHS = true;
        int i = 0;
        int j = 0;
        int isPlus = true;
        int cur;
        string temp;
        while(j<n){
            if(equation[j] == 'x'){
                temp = equation.substr(i,j-i);
                if(temp.length() == 0){
                    if(isPlus){
                        if(isLHS)
                            coef+=1;
                        else
                            coef-=1;
                    }else{
                        if(!isLHS)
                            coef+=1;
                        else
                            coef-=1;
                    }
                }else{
                    cur = stoi(temp);
                    if(isPlus){
                        if(isLHS)
                            coef+=cur;
                        else
                            coef-=cur;
                    }else{
                        if(!isLHS)
                            coef+=cur;
                        else
                            coef-=cur;
                    }
                }
                j++;
                i=j;
            }else if(equation[j]>='0' && equation[j]<='9'){
                j++;
                continue;
            }else if(equation[j] == '+' || equation[j] == '-'){
                temp = equation.substr(i,j-i);
                if(temp.length()!=0){
                    cur = stoi(temp);
                    if(isPlus){
                        if(isLHS)
                            intercept-=cur;
                        else
                            intercept+=cur;
                    }else{
                        if(isLHS)
                            intercept+=cur;
                        else
                            intercept-=cur;
                    }
                }                
                if(equation[j] == '+')
                    isPlus = true;
                else
                    isPlus = false;
                j++;
                i=j;
            }else{
                temp = equation.substr(i,j-i);
                if(temp.length()!=0){
                    cur = stoi(temp);
                    if(isPlus){
                        intercept-=cur;
                    }else{
                        intercept+=cur;
                    }
                }
                j++;
                i = j;
                isLHS = false;
                isPlus = true;
            }
        }
        temp = equation.substr(i,j-i);
        if(temp.length() != 0){
            cur = stoi(temp);
            if(isPlus){
                intercept+=cur;
            }else{
                intercept-=cur;
            }
        }
        if(coef == 0){
            if(intercept == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }else{
            return "x=" + to_string(intercept / coef);
        }
    }
};
