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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        List<Integer> cur ;
        int level = 0;
        queue.add(root);
        int size;

        while(!queue.isEmpty()){
            size = queue.size();
            level++;
            cur = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.remove();
                if(level%2 == 0)
                    cur.addFirst(temp.val);
                else
                    cur.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            ans.add(cur);
        }
        return ans;
    }
}
