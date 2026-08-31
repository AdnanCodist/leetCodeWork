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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int i = 1;

        ListNode prev = head;
        ListNode curr = prev.next;

        int firstCriticalPP = -1;
        int prevCriticalPP = -1;

        int smallDist = Integer.MAX_VALUE;

        while (curr.next != null) {

            // minima
            if ((curr.val < curr.next.val) && (curr.val < prev.val)) {
                if (firstCriticalPP == -1) {
                    firstCriticalPP = i;
                    prevCriticalPP = i;
                } else {
                    smallDist = Math.min(smallDist, i - prevCriticalPP);
                    prevCriticalPP = i;
                }
            }

            // maxima
            if ((curr.val > curr.next.val) && (curr.val > prev.val)) {
                if (firstCriticalPP == -1) {
                    firstCriticalPP = i;
                    prevCriticalPP = i;
                } else {
                    smallDist = Math.min(smallDist, i - prevCriticalPP);
                    prevCriticalPP = i;
                }
            }

            prev = curr;
            curr = curr.next;
            i++;
        }

        // Fewer than two critical points
        if (firstCriticalPP == -1 || firstCriticalPP == prevCriticalPP) {
            return new int[] { -1, -1 };
        }

        int largeDist = prevCriticalPP - firstCriticalPP;

        return new int[] { smallDist, largeDist };

        // retrun
    }
}