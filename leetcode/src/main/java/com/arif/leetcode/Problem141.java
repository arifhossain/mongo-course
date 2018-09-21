package com.arif.leetcode;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */

public class Problem141 {

    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        // 1->2->3->4->5->2
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = two;

        System.out.println("Has Cycle: " + new Problem141().hasCycle(one));
    }

}

