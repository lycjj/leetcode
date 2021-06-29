package com.ly.leetcode;

/**
 * 反转链表
 * @author ly.
 * @date 2021/5/25
 */
public class QuestionOffer24 {
    public ListNode reverseList(ListNode head) {
        ListNode firstNode = new ListNode(0),next = null;
        ListNode node = head,nodeNext = head;
        while (node != null) {
            nodeNext = node.next;
            firstNode.next = node;
            node.next = next;
            node = nodeNext;
            next = firstNode.next;
        }
        return firstNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}


