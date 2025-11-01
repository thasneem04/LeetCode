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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            int a = curr.val;
            int b = curr.next.val;
            int g = gcd(a, b);
            // insert new node with value g between curr and curr.next
            ListNode inserted = new ListNode(g, curr.next);
            curr.next = inserted;
            // move curr to the next original node (skip the inserted node)
            curr = inserted.next;
        }
        return head;
    }

    // Euclidean algorithm for gcd
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
