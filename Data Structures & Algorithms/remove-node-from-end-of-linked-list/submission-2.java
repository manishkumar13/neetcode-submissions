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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Calculate length of linked list
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // If first node needs to be removed
        if (length == n) {
            return head.next;
        }

        // Find node just before the one to be deleted
        curr = head;
        for (int i = 1; i < length - n; i++) {
            curr = curr.next;
        }

        // Delete the target node
        curr.next = curr.next.next;

        return head;
    }
}
