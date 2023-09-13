public class Solution {
    public bool IncreasingTriplet(int[] nums) {
                
        int size=nums.Length;
        if(size<3)return false;
        int largest = nums.Max();
        int largest2 = nums.Max(); 

        foreach(int element in nums){
            if(element<=largest)
                largest = element;
            else if(element<=largest2)
                largest2 = element;
            else
                return true;
        }

        return false;
    }
}
