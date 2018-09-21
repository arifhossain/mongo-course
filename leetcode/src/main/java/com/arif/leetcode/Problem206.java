package com.arif.leetcode;


/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */

public class Problem206 {

    public ListNode reverseList(ListNode head) {

        if(head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current.next != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        current.next = prev;
        return current;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        // 1->2->3->4->5
        one.next = two;
        two.next = three;
        three.next = four;
//        four.next = five;

        System.out.println("Original: " + one.toString());
        System.out.println("Reversed: " + new Problem206().reverseList(one).toString());
    }
}
