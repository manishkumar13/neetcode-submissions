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
    /**
     * Finds the middle node of the linked list.
     * For even length lists, returns the last node of the first half.
     *
     * Example:
     * 1 -> 2 -> 3 -> 4 -> 5  => returns 3
     * 1 -> 2 -> 3 -> 4       => returns 2
     */
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * Reverses a linked list and returns the new head.
     *
     * Example:
     * 4 -> 5 -> null
     * becomes
     * 5 -> 4 -> null
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next; // Save next node

            head.next = prev; // Reverse current link

            prev = head; // Move prev forward
            head = next; // Move current forward
        }

        return prev;
    }

    /**
     * Merges two lists in alternating fashion.
     *
     * Example:
     * first  = 1 -> 2 -> 3
     * second = 5 -> 4
     *
     * Result:
     * 1 -> 5 -> 2 -> 4 -> 3
     */
    private void merge(ListNode first, ListNode second) {
        while (second != null) {
            // Store next nodes before modifying links
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;

            // Insert node from second list after current first node
            first.next = second;
            second.next = nextFirst;

            // Move both pointers forward
            first = nextFirst;
            second = nextSecond;
        }
    }

    public void reorderList(ListNode head) {
        // Edge case: empty list or single node list
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle node of the linked list
        ListNode middle = findMiddle(head);

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverse(middle.next);

        // Break the list into two halves
        middle.next = null;

        // Step 3: Merge the two halves alternately
        merge(head, secondHalf);
    }
}
