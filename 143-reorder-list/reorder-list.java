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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode hf = head;
        ListNode hs = reverseList(mid);

        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        if (hf != null) {
            hf.next = null;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; //since fast is moving twice as slow- when it reaches end, slow will be in the middle
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;

        while (present != null) {
            ListNode next = present.next; // Save next node first
            present.next = prev; // Reverse the link
            prev = present; // Move prev forward
            present = next; // Move present forward
        }

        return prev;
    }
}