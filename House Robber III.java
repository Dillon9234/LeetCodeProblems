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
    public int rob(TreeNode root) {
        myReturn ans = helper(root);
        return Math.max(ans.prev,ans.prev2);
    }

    private myReturn helper(TreeNode root){
        if(root == null)
            return new myReturn(0,0) ;
        myReturn left = helper(root.left);
        myReturn right = helper(root.right);

        int includedRoot = root.val + left.prev2 + right.prev2;
        int excludedRoot = left.prev + right.prev;
        
        return new myReturn(Math.max(includedRoot,excludedRoot),excludedRoot);

    }
}

class myReturn{
    int prev;
    int prev2;
    public myReturn(int i, int j){
        prev = i;
        prev2 = j;
    }
}
