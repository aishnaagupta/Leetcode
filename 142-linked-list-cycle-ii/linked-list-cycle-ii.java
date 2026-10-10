/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int len = 0;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                len = lengthOfCycle(slow);
                break;
            }
        }

        if (len == 0) {
            return null;
        }

        //find start node
        ListNode first = head;
        ListNode second = head;

        while (len > 0) {
            second = second.next;
            len--;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return second;

    }

    public int lengthOfCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow; //let slow wherever it is and move temp until it comes back to slow
                int len = 0;
                do {
                    len++;
                    temp = temp.next;
                } while (temp != slow);

                return len;
            }
        }

        return 0;
    }
}