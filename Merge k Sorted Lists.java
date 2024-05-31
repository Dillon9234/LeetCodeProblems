/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int n;
    ListNode[] lists;
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n==0)
            return null;
        this.lists = lists;
        return helper(0, n);
    }
    private ListNode helper(int start, int end){
        int size = end-start;
        if(size == 1)
            return lists[start];
        ListNode left = helper(start,start+size/2);
        ListNode right = helper(start+size/2,start+size);
        return merge(left, right);
    }
    private ListNode merge(ListNode left,ListNode right){
        if(left == null)
            return right;
        if(right == null)
            return left;
        ListNode root;
        if(left.val<right.val){
            root = left;
            left = left.next;
        }else{
            root = right;
            right = right.next;
        }
        ListNode temp = root;
        while (left!=null&&right!=null) {
            if(left.val<right.val){
                root.next = left;
                left = left.next;
            }else{
                root.next = right;
                right = right.next;
            }
            root = root.next;
        }
        if(left!=null)
            root.next = left;
        else
            root.next = right;
        return temp;
    }
}
