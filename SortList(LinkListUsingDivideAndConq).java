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
    private ListNode split(ListNode head){
        ListNode slow = head;
        while(head.next!=null&&head.next.next!=null){
            head = head.next.next;
            slow = slow.next;
        }
        head = slow;
        slow = slow.next;
        head.next = null;
        return slow;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head;
        if(l1.val<l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        ListNode temp = head;
        while (l1!=null&&l2!=null) {
            if(l1.val<l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1!=null) {
            head.next = l1;
        }
        else{
            head.next = l2;
        }
        return temp;
    }
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode slow = split(head);
        head = sortList(head);
        slow = sortList(slow);
        return merge(head, slow);
    }
}
