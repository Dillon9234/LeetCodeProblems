class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n=heights.length;   
        int[] leftSmallest = GetLeftSmaller(heights,n);
        int[] rightSmallest = GetRightSmaller(heights,n);
        for(int i=0;i<n;i++){
            max = Math.max(max,(rightSmallest[i]-leftSmallest[i]-1)*heights[i]);
        }
        return max;
    }

    private int[] GetLeftSmaller(int[] heights,int n){
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                stack.pop();
            output[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return output;
    }
    private int[] GetRightSmaller(int[] heights,int n){
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                stack.pop();
            output[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return output;
    }
}
