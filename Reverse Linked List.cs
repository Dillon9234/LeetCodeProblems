public class Solution {
    public ListNode ReverseList(ListNode head) {

        ListNode p,q = null,r = null;
        p=head;
        while(p!=null){

            r=q;
            q=p;
            p=p.next;
            q.next = r;

        } 
        return q;
        
    }
}
