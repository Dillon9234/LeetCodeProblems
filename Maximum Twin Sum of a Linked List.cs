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
    public int PairSum(ListNode head)
    {
        ListNode cur = head;
        int size = 0;
        Stack<int> stack = new Stack<int>();

        while (cur != null)
        {
            stack.Push(cur.val);
            cur = cur.next;
            size++;
        }
        int maxSum = 0;
        
        int count = 0;
        while(count<size/2)
        {
            maxSum = Math.Max(maxSum, head.val + stack.Pop());
            head = head.next;
            count++;
        }
        return maxSum;

    }
}
