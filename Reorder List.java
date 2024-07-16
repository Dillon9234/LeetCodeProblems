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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head, temp = null;

        if(head.next == null)
            return;
        while(fast!=null && fast.next!=null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        
        fast = reverseList(slow);
        slow = head;
        while(slow!=null){
            temp = slow.next;
            slow.next = fast;
            slow = fast;
            fast = fast.next;
            if(temp!=null)
                slow.next = temp;
            slow = temp;
        }
    }

    private ListNode reverseList(ListNode head){
        ListNode l,m,f;
        l = null;
        m = head;
        f = head;

        while(m != null){
            f = f.next;
            m.next = l;
            l = m;
            m = f;
        }
        return l;
    }
}
