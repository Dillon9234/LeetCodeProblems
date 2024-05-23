import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        Integer temp;          
        for(int i =0;i<n;i++){
            temp = map.get(target - nums[i]);
            if(temp != null)
                return new int[] {i,temp};
            map.put(nums[i], i);
        }
        return null;
    }
}
