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
        ListNode temp = head;
        //size calculation
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (size == n) {
            return head.next;
        }

        ListNode prev = find(head, size - n - 1);
        if (size == 2) {
            prev.next = null;
            return prev;
        }

        prev.next = prev.next.next;

        return head;
    }

    public ListNode find(ListNode head, int index) {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}