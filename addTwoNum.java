/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carrier = 0;
        ListNode ll1 = l1;
        ListNode ll2 = l2;

        while (ll1 != null || ll2 != null) {
            int sum = carrier + (ll1 == null ? 0 :ll1.val) + (ll2 == null ? 0 : ll2.val);
            int val = sum % 10;
            carrier = sum / 10;
            ListNode new_node = new ListNode(val);
            cur.next = new_node;
            cur = cur.next;
            ll1 = (ll1 == null ? null : ll1.next);
            ll2 = (ll2 == null ? null : ll2.next);
        }

        if (carrier != 0) {
            ListNode new_node = new ListNode(carrier);
            cur.next = new_node;
        }

        return dummy.next;
    }
}