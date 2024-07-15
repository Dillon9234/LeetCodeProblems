class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        if(k>n)
            return 0;
        int[] window = new int[k];
        int i=0;
        int count = 0;
        int ans = 0;
        while(i<n){
            if(colors[i]!=colors[(i+1)%n]){
                count = 2;
                int j = (i+1)%n;
                while(count<k){
                    if(colors[j]==colors[(j+1)%n]){
                        i += count-1;
                        break;
                    }else{
                        j = (j+1)%n;
                        count++;
                    }
                }
                j = (i+k-1)%n;
                if(count == k){
                    ans++;
                    while(i<n-1){
                        if(colors[j]==colors[(j+1)%n]){
                            break;
                        }else{
                            i++;
                            j = (j+1)%n;
                            ans++;
                        }
                    }
                }
            }
            i++;
        }
        return ans;
    }
}
