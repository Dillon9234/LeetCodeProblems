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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a,b,c,e,root;
        if(!testPossible(head,k))
            return head;
        boolean rootSet = false;
        root = head;
        a = null;
        e = null;
        b = head;
        c = head;
        int count = 0;
        while(c!=null){
            c = c.next;
            b.next = a;
            a = b;
            b = c;
            count++;
            if(count == k){
                count = 0;
                ListNode temp = null; 
                if(e!=null){
                    temp = e.next;
                    e.next = a;
                }
                if(!rootSet){
                    rootSet = true;
                    root = a;
                }
                if(temp!=null)
                    a = temp;
                else
                    a = head;
                a.next = b;
                e = a;
                if(!testPossible(b,k))
                    break;
            }
        }
        return root;
    }
    private boolean testPossible(ListNode head, int k){
        int count = 0;
        while(head!=null && count<k){
            head = head.next;
            count++;
        }
        return count ==k;
    }
}
