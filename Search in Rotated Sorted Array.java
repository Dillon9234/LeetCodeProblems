class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==1 &&  nums[0] == target){
            return 0;
        }
        int pivot = 0;
        int left = 0;
        int right = n-1;
        int mid;
        int actual;
        while(right>=left){
            mid = (left+right)/2;
            if(nums[mid]>=nums[pivot]){
                pivot = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        right = n-1;
        left = 0;
        while(left<=right){
            mid = (left+right)/2;
            actual = (mid+pivot+1)%n;
            if(nums[actual] == target){
                return actual;
            }else if(nums[actual] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
