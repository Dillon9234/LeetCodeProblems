/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(!head || !head->next)
            return head;
        
        ListNode* back = head;
        ListNode* front;
        
        ListNode* temp = new ListNode();
        ListNode* prev = temp;

        while(back && back->next){
            front = back->next;
            prev->next = front;
            back->next = front->next;
            front->next = back;
            prev = back;
            back = back->next;     
        }

        return temp->next;
    }
};
