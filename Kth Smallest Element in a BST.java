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
    int count = 0;
    int k;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traverse(root);
        return ans;
    }
    private void traverse(TreeNode root){
        if(root.left != null)
            traverse(root.left);
        count++;
        if(count == k){
            ans = root.val;  
            return;
        }else if(count>k)
            return;
        if(root.right != null)
            traverse(root.right);
    }
}
