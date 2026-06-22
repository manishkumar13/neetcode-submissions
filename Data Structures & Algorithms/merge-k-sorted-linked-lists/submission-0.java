/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Merge lists in pairs:
        // interval = 1 => merge every 2 lists
        // interval = 2 => merge every 4 lists
        // interval = 4 => merge every 8 lists
        int interval = 1;

        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                // Merge current pair of lists
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }

            interval *= 2;
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // Merge two sorted linked lists
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        // Attach remaining nodes
        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
