class Solution {
public:
    ListNode *sortList(ListNode *head) {
         if (head == nullptr || head->next == nullptr) return head;
         int count = 1;
         ListNode *dummy = new ListNode(-1);
         dummy->next = head;
         ListNode *fast = head;
         ListNode *slow = dummy;
         while (fast) {
             if (count % 2 == 0)
                 slow = slow->next;
             fast = fast->next;
             count++;
         }

         fast = slow;
         slow = slow->next;
         fast->next = nullptr;

         ListNode *l1 = sortList(head);
         ListNode *l2 = sortList(slow);
         return mergeList(l1, l2); 
    }
private:
    ListNode *mergeList(ListNode *head1, ListNode *head2) {
        ListNode *cur1 = head1;
        ListNode *cur2 = head2;
        ListNode *newhead = nullptr;
        ListNode *cur = nullptr;

        while (cur1 && cur2) {
            ListNode *temp = cur1->val <= cur2->val ? cur1 : cur2;
            if (newhead == nullptr)
                newhead = temp;
            else cur->next = temp;
            cur = temp;
            if (temp == cur2) cur2 = cur2->next;
            else cur1 = cur1->next;
        }
        
        cur->next = (cur1 == nullptr) ? cur2 : cur1;
        return newhead;
    }
};
