#define MaxSize 100

struct ListNode {
      int val;
      struct ListNode *next;
  };

struct ListNode* end;

struct ListNode* insert(struct ListNode* start,int val){
    struct ListNode* temp = (struct ListNode*)malloc(sizeof(struct ListNode));
    temp->next=NULL;
    temp->val = val;
    if(start==NULL){
        end = temp;
        return temp;
    }
    
    end->next = temp;
    end = end->next;
    return start;
}

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    int carry=0;
    struct ListNode* head = NULL;
    while(l1!=NULL&&l2!=NULL){
        int sum = l1->val+l2->val+carry;
        if(sum>=10){
            carry = (sum/10)%10;
            sum=sum%10;
        }else
        carry = 0;
        head = insert(head,sum);
        l1=l1->next;
        l2=l2->next;
    }
        while(l1==NULL&&l2!=NULL){
        int sum = l2->val + carry;
        if(sum>=10){
           carry = (sum/10)%10;
            sum=sum%10;
        }else
        carry = 0;
        head = insert(head,sum);
        l2=l2->next;
    }
        while(l2==NULL&&l1!=NULL){
        int sum = l1->val + carry;
        if(sum>=10){
            carry = (sum/10)%10;
            sum=sum%10;
        }else
        carry = 0;
        head = insert(head,sum);
        l1=l1->next;
    }
    if(carry!=0){
        head = insert(head,carry);
    }
    return head->next;
    

}
