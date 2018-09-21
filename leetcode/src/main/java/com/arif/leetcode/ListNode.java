package com.arif.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode head = this;
        while (head.next != null) {
            builder.append(head.val + "->");
            head = head.next;
        }
        builder.append(head.val + "->NULL");
        return builder.toString();
    }
}
