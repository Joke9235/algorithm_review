package com.zqr.leetcode.day07;

/**
 * @author Kendric
 * @className ListNode
 * @description
 * @createTime 2021/10/21 16:17
 */
//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String string = "ListNode{" +
                "val=" + val +
                "}\n";
        ListNode listNode = this;
        while (listNode.next != null) {
            listNode = listNode.next;
            string += "ListNode{" +
                    "val=" + listNode.val +
                    "}\n";
        }
        return string;
    }
}
