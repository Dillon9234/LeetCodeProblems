class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr1 = 0;
        int len = nums.length;
        int ptr2 = len-1;

        while(ptr1<=ptr2){
            if(nums[ptr1]==val){
                len--;
                nums[ptr1] = nums[ptr2--];
                continue;
            }
            ptr1++;
        }

        return len;
    }
}
