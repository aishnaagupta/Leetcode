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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        ListNode node = find(head, size / 2);
        ListNode mid = node;

        return mid;
    }

    public ListNode find(ListNode head, int size) {
        ListNode node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
        }
        return node;
    }
}