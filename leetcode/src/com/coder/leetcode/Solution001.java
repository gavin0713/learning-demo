package com.coder.leetcode;

import com.coder.leetcode.basic.ListNode;

/**
 * Created by kougavin on 11/09/2021.
 */
public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution001.reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0, head);
        ListNode last = protect;

        while (head != null) {
            ListNode end = getEnd(head, k);
            if (end == null) break;
            ListNode nextGroupHead = end.next;

            reverse(head, end);
            last.next = end;
            head.next = nextGroupHead;

            last = head;
            head = nextGroupHead;
        }
        return protect.next;
    }

    private ListNode getEnd(ListNode head, int k) {
        while (head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }

    private void reverse(ListNode head, ListNode end) {
        if (head == end) return;
        ListNode last = head;
        head = head.next;
        while (head != end) {
            ListNode nextHead = head.next;
            head.next = last;

            last = head;
            head = nextHead;
        }
        end.next = last;
    }
}
