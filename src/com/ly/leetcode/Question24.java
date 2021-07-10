package com.ly.leetcode;

import java.util.List;

/**
 * @author ly.
 * @date 2021/7/10
 */
public class Question24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head, pre = null;
        if (node.next == null) {
            return head;
        }
        ListNode temp = node.next.next;
        // 需要考虑当node为null或者后面只剩一个节点时，就停止循环
        while (node != null && node.next != null) {
            if (pre != null) {
                pre.next = node.next;
            }
            if (node == head) {
                head = node.next;
            }
            node.next.next = node;
            node.next = temp;
            pre = node;
            node = node.next;
            if(node != null && node.next != null) {
                temp = node.next.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode head = new Question24().swapPairs(node1);
        System.out.println(head);
    }

    static class ListNode {
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
    }
}
