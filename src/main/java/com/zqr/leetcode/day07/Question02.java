package com.zqr.leetcode.day07;

/**
 * @author Kendric
 * @className Question02
 * @description 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @createTime 2021/10/21 16:14
 */

public class Question02 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3.toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        listNode.val = l1.val + l2.val;
        if (l1.next != null && l2.next != null) {
            listNode.next = addTwoNumbers(l1.next, l2.next);
        }
        return listNode;
    }
}
