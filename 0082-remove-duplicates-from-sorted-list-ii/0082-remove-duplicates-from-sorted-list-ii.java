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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {

                int duplicateNumber = curr.val;

                while (curr != null && curr.val == duplicateNumber) {
                    curr = curr.next;
                }

                prev.next = curr;

            } else {

                // move prev move curr //
                prev = curr;
                curr = curr.next;

            }
        }

        return dummy.next;

        //rturn
    }
}