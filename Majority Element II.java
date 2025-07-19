class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        } 
        map.forEach((key, value) -> {
            if(value>n/3){
                output.add(key);
            }
        });
        return output;
    }
}
