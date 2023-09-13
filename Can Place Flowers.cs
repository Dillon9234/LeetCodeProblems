public class Solution {
    public bool CanPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.Length;
        
        if(n==0)
        return true;

        if(size==1){
            if(flowerbed[0]==0)
            return n-1 <= 0;
            else return n <= 0;
        }

        if(flowerbed[0] + flowerbed[1]==0){
            flowerbed[0]=1;
            n--;
        }

        if(flowerbed[size -1] + flowerbed[size -2]==0&&n!=0){
            flowerbed[size-1]=1;
            n--;
        }
        if(n==0)
        return true;
        
        for(int i=1;i<size-1&&n!=0;i++){
            if(flowerbed[i]+ flowerbed[i-1] + flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }
        }

        return n == 0 ;
        
    }
}
