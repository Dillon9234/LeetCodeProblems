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
    ListNode* partition(ListNode* head, int x) {
        if(!head || !head->next)
            return head;
        ListNode* lesser;
        ListNode* greater;
        ListNode* tip1 = NULL;
        ListNode* tip2 = NULL;
        if(head->val>=x){
            greater = head;
            tip2 = head;
        }else{
            lesser = head;
            tip1 = head;
        }
        head = head->next;
        while(head){
            if(head->val < x ){
                if(!tip1){
                    tip1 = head;
                }else{
                    lesser->next = head;
                }
                lesser = head;
            }else{
                if(!tip2){
                    tip2 = head;
                }else{
                    greater->next = head;
                }
                greater = head;
            }
            head = head->next;
        }
        if(!tip1)
            return tip2;
        if(!tip2)
            return tip1;
        lesser->next = tip2;
        greater->next = NULL;
        return tip1;
    }
};
