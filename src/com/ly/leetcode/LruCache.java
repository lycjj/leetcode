package com.ly.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用哈希表+双向链表实现LRU缓存
 * LRU缓存：最近最少使用
 * 首先会有一个最大的容量，当向其中加入值的时候，如果当前容量已满，则将最近最少使用的元素删去，再加入新元素
 * @author ly.
 * @date 2021/5/31
 */
public class LruCache {

    private Map<Integer,DLinkedNode> cache = new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    public LruCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.prev = tail;
        tail.next = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            node = new DLinkedNode(key,value);
            cache.put(key,node);
            addToHead(node);
            size++;
            if(size >capacity) {
                DLinkedNode tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
         head.next.prev = node;
         head.next = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    class DLinkedNode{
        private int key;
        private int value;
        private DLinkedNode next;
        private DLinkedNode prev;

        public DLinkedNode() {
            super();
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
