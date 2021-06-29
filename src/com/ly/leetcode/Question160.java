package com.ly.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 用哈希集合
 * @author ly.
 * @date 2021/6/4
 */
public class Question160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,ListNode> map = new HashMap<ListNode,ListNode>();
        ListNode node = headA;
        while (node != null) {
            map.put(node,node);
            node = node.next;
        }

        node = headB;
        while (node != null) {
            if(map.containsKey(node)) {
                return node;
            }
            node  = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(8);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(0);
        node6.next = node7;
        ListNode node8 = new ListNode(1);
        node7.next = node8;
        node8.next = node3;
        ListNode result = getIntersectionNode(node1,node6);
        System.out.println(result.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
