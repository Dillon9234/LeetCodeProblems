class Solution {
    List<List<Integer>> ans;
    int n ;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            helper(i,nums,new ArrayList<>());
        }
        return ans;
    }

    private void helper(int ptr,int[] nums,List<Integer> prev){
        List<Integer> cur = new ArrayList<>(prev);
        cur.add(nums[ptr]);
        ans.add(cur);
        for(int i = ptr+1;i<n;i++){
            helper(i,nums,cur);
        }
        return;
    }
}
