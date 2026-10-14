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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddR = null;
        ListNode evenR = head.next;

        while (odd != null && even != null) {
            if (odd.next.next == null) {
                oddR = odd;
            }

            ListNode oddTemp = odd.next.next;
            odd.next = oddTemp;
            odd = odd.next;

            if (even.next == null) {
                break;
            }

            ListNode evenTemp = even.next.next;
            even.next = evenTemp;
            even = even.next;
        }

        if (oddR == null) {
            oddR = odd;
        }

        oddR.next = evenR;

        return head;
    }
}