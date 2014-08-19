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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode d = dummy;
        ListNode prev = head;
        ListNode cur = prev.next;
        ListNode last = head;
        ListNode first = head;

        int count = 0;
        while (true) {
            if (count == k) {
                // reverse k nodes
                while (cur != last) {
                    first = d.next;
                    d.next = cur;
                    prev.next = cur.next;
                    cur.next = first;
                    cur = prev.next;
                }
                if (last == null) break;
                d = prev;
                first = d.next;
                prev = first;
                cur = prev.next;
                count = 0;
            }
            if (last == null) break;
            last = last.next;

            count++;
        }

        return dummy.next;
    }
}