package com.ly.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ly.
 * @date 2021/7/3
 */
public class Question142 {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        ListNode node = head;
        while (node != null) {
            if (!map.isEmpty() && map.containsKey(node)) {
                return node;
            }
            map.put(node, node);
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(0);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        node4.next = node2;
        ListNode result = new Question142().detectCycle(node1);
        System.out.println(result.val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
