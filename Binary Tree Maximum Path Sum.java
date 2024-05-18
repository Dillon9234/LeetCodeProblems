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
    int max;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        max = root.val;
        traverse(root);
        return  max;
    }
    private int traverse(TreeNode root){
        if(root == null)
            return 0;

        //DFS
        int leftMax = traverse(root.left);
        int rightMax = traverse(root.right);

        //Choosing the best path from this root 
        int sideMax = Math.max(leftMax, rightMax);

        //finding max of this subtree. We are trying each node as a root and finding its max path sum
        max = Math.max(max, Math.max(root.val, sideMax + root.val));
        max = Math.max(max, leftMax + rightMax + root.val);
        //returing the best path from leaf to this node
        return Math.max(root.val + sideMax,root.val);
    }
}
