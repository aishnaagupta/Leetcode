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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); //new list creation
        ListNode tail = dummyHead; //tail=dummyH=0
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int d1 = (l1 != null) ? l1.val : 0;
            int d2 = (l2 != null) ? l2.val : 0;

            int sum = d1 + d2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(digit); //add sum node at the end of new list
            tail.next = node; //0 now points to new node(new node successfully added at the end)
            tail = tail.next; //move tail forward

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode res = dummyHead.next; //ignore starting head taken as 0
        dummyHead.next = null; //detach dummyHead (ie. 0) from res list
        return res; //eg 7->0->8
    }
}