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
    ArrayList<Integer> list;
    public ArrayList<Integer> sumNumbers(TreeNode root) {
        list = new ArrayList<>();
        Stack<Integer> cur = new Stack<>();
        traverse(root,cur);
        int sum=0;
        return list;
    }

    public void traverse(TreeNode root,Stack<Integer> cur){
        cur.push(root.val);
        if(root.left != null){
            traverse(root.left,cur);
        }
        if(root.right != null)
            traverse(root.right,cur);
        if(root.left == null && root.right == null){
            int num =0;
            double factor = 0;
            int size = cur.size();
            for (int i = size-1;i>=0;i--) {
                factor = Math.pow(10, size - i-1);
                num += cur.elementAt(i)*factor;
            }
            list.add(num);
        }
        cur.pop();
    }
}
