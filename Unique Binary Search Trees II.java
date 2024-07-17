/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode>[][] dp;
    public List<TreeNode> generateTrees(int n) {
        dp = new ArrayList[n+1][n+1];
        int min = 1;
        int max = n;
        return generateAllWithN(min,max);
    }

    private List<TreeNode> generateAllWithN(int min, int max){
        List<TreeNode> output = new ArrayList<>(); 
        if(min > max){
            output.add(null);
            return output;
        }
        if(dp[min][max]!=null){
            return dp[min][max];
        }
        for(int i =min;i<=max;i++){
            List<TreeNode> left = generateAllWithN(min,i-1);
            List<TreeNode> right = generateAllWithN(i+1,max);
            for(TreeNode leftNode: left){
                for(TreeNode rightNode: right){
                    output.add(new TreeNode(i,leftNode,rightNode));
                }
            }
        }
        
        return dp[min][max] = output;
    }
}
