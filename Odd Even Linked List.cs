//My soln
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution
{
    public ListNode OddEvenList(ListNode head)
    {
        ListNode end = head;
        int count = 1;
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        while (end.next  != null)
        {
            end = end.next;
            count++;
        }
        ListNode current = head.next;
        ListNode prev = head;
        int pos = 2;
        while (pos<=count)
        {
            if (pos%2 == 0)
            {
                prev.next = current.next;
                end.next = current;
                current.next = null;
                end = end.next;
                current = prev.next;
            }
            else
            {
                prev = current;
                current = current.next;
            }
            pos++;
        }



        return head;
    }

}

//Best Soln
public class Solution {
    public ListNode OddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = oddHead;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return oddHead;
    }
}
