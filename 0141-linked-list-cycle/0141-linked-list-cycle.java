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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          //  moves 1 step
            fast = fast.next.next;     //  moves 2 steps

            if (slow == fast) {        // They meet when cycle exists
                return true;
            }
        }

        return false; // fast reached end if no cycle
    }
}
