struct ListNode* recur(struct ListNode* head, int *curr, int n) {
        if(head == NULL)
            return NULL;
        
        head->next = recur(head->next, curr, n);
        
        (*curr)++;
        
        if(*curr == n)
            return head->next;
        else
            return head;
    }
    
    struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
        int pos = 0;
        return recur(head, &pos, n);
    }
