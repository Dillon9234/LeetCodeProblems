public class Solution {
    public int MaxArea(int[] height) {
        int max=0,current=0;
        int i=0,j=height.Length-1;
        
        while(j>i){

            current = Math.Min(height[i],height[j])*(j-i);

            if(current>max)
            max = current;

        if(height[i]==height[j]){
                i++;
                j--;
        }else if(height[i]<height[j]){
                i++;
        }else{
                j--;
        }
        }
        return max;
    }
}
