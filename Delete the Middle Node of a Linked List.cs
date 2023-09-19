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
    public ListNode DeleteMiddle(ListNode head)
    {
        if(head.next==null)return null;
        if(head.next.next==null){
            head.next=null;
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while(temp!= null)
        {
            temp = temp.next;
            count++;
        }
        int position = count / 2-1;
        temp = head;
        while(position > 0)
        {
            temp = temp.next;
            position--;
        }

        temp.next = temp.next.next;
        return head;

    }
}
