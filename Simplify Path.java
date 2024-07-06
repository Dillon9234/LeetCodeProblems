class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int ptr1 = 0;
        int ptr2 = 1;
        int n = path.length();
        StringBuilder ans = new StringBuilder();
        if(n == 0)
            return path;
        if(path.charAt(0) == '/')
            ptr1++;
        while(ptr2<n){
            if(path.charAt(ptr2) == '/'){
                if(ptr1 != ptr2){
                    String temp = path.substring(ptr1,ptr2);
                    if(temp.equals(".")){
                        ptr2++;
                        ptr1 = ptr2;
                        continue;
                    }
                    if(temp.equals("..")){
                        if(!stack.isEmpty())
                            stack.pop();
                    }else
                        stack.push(temp);
                }
                ptr2++;
                ptr1 = ptr2;
            }else{
                ptr2++;
            }
        }
        if(ptr1 != ptr2){
            String temp = path.substring(ptr1,ptr2);
            if(!temp.equals("."))
                if(temp.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else
                    stack.push(temp);
        }
        if(stack.isEmpty())
            return "/";
        for(String str: stack){
            ans.append('/');
            ans.append(str);
        }
        return ans.toString();
    }
}
