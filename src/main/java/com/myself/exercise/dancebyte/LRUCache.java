package com.myself.exercise.dancebyte;

import java.util.HashMap;
import java.util.Map;

/**
 * 访问次数优先
 */
 class LRUCache {

    static class DoubleLinkNode {
        int key, value;
        DoubleLinkNode pre;
        DoubleLinkNode next;

        DoubleLinkNode() {

        }

        DoubleLinkNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Map<Integer, DoubleLinkNode> cache = new HashMap<>();
    int size = 0;
    int capacity = 0;
    DoubleLinkNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.next = tail;
        tail.pre = head;
    }


    public int get(int key) {
        return -1;
    }

    public void put(int key, int value) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) {
            node = new DoubleLinkNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                DoubleLinkNode last = removeTail();
                cache.remove(last.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


    public void moveToHead(DoubleLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(DoubleLinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(DoubleLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public DoubleLinkNode removeTail() {
        if (head == tail.pre) {
            return null;
        }
        DoubleLinkNode node = tail.pre;
        removeNode(node);
        return node;
    }


}
