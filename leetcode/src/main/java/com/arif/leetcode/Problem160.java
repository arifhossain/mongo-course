package com.arif.leetcode;

/**
 * Intersection of two lists.
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 */

public class Problem160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode startA = headA;
        ListNode startB = headB;
        ListNode endA, endB;

        // Find end of A
        while (startA.next != null) {
            startA = startA.next;
        }
        endA = startA;

        // Find end of B
        while (startB.next != null) {
            startB = startB.next;
        }
        endB = startB;

        // They have a intersection only if their last node is same
        if (endA == endB) {
            startA = headA;
            startB = headB;

            while (true){
                if (startA == startB) {
                    return startA;
                }

                startA = startA.next != null ? startA.next : headB;
                startB = startB.next != null ? startB.next : headA;
            }
        }

        return null;

    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);

        // 1->2->3->4->5
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        // 6->7->4->5
        // intersection at four
        six.next = seven;
        seven.next = four;

        System.out.println(new Problem160().getIntersectionNode(one, one).val);
    }

}
