class Solution {
    List<List<Integer>> output;
    int n;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        output = new ArrayList<>();
        n = candidates.length;

        helper(0,0,new Stack<Integer>());
        return output;
    }

    private boolean helper(int ptr, int sum, Stack<Integer> stack){
        if(sum == target){
            output.add(new ArrayList<>(stack));
            return false;
        }
        if(sum > target){
            return true;
        }
        for(int i=ptr;i<n;i++){
            sum+=candidates[i];
            stack.push(candidates[i]);
            boolean temp = helper(i,sum,stack);
            sum-=candidates[i];
            stack.pop();
            if(temp)
                break;
        }
        return false;
    }
}
