class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) 
            set.add(i);
        int max = 0;
        for (int i : nums) {
            int left = i-1;
            int right = i+1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            max = Math.max(max, right-left-1);
            if(set.isEmpty())
                break;
        }
        return max;
    }
}
