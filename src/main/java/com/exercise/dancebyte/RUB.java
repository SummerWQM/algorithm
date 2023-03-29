package com.exercise.dancebyte;

import java.util.HashMap;

public class RUB {


    static class Node<K, V> {
        Node<K, V> prev;
        Node<K, V> next;
        K key;
        V val;

        Node() {
        }

        Node(K k, V e) {
            this.key = k;
            this.val = e;
        }

        public K getKey() {
            return key;
        }

    }

    static class DoublyLink<K, V> {
        Node<K, V> head, tail;
        Integer size;

        DoublyLink() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node<K, V> node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node<K, V> removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node<K, V> last = tail.prev;
            remove(last);
            return last;
        }

        public int size() {
            return size;
        }

        public void addLast(Node<K, V> node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

    }


    static class RU<K, V> {

        DoublyLink<K, V> cache = new DoublyLink<>();
        HashMap<K, Node<K, V>> map = new HashMap<>();
        int capacity;

        RU(int cap) {
            this.capacity = cap;
        }

        public void put(K key, V val) {
            Node<K, V> node = new Node<>(key, val);
            if (map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(node);
                map.put(key, node);
            } else {
                if (cache.size() == capacity) {
                    Node<K, V> last = cache.removeLast();
                    map.remove(last.getKey());
                }
                cache.addFirst(node);
                map.put(key, node);
            }
        }

        public V get(K k) {
            if (!map.containsKey(k)) {
                return null;
            }
            Node<K, V> node = map.get(k);
            cache.remove(node);
            cache.addFirst(node);
            return node.val;
        }
    }

    public static void main(String[] args) {

        RU<String, Integer> lru = new RU<>(2);

        lru.put("a", 1);
        lru.put("b", 2);
        lru.put("c", 3);

        System.out.println(lru.get("c"));
        System.out.println(lru.get("b"));
        System.out.println(lru.get("a"));
    }

}
