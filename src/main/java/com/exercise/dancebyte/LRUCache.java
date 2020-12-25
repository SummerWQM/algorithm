package com.exercise.dancebyte;

import com.helper.DoubleList;
import com.helper.Node;

import java.util.HashMap;

// 使用 链表 主要是为了  删除 节点 (O)1 复杂度

// 使用 map 主要是用于 get 值可以满足 (O1) 复杂度。
// LRU 需要满足 被写入时 如果 容量不够 需要删除 越久没有被跟新的元素，链表末尾的 及是没有被 平凡访问的
// 因为 被访问的 都要 从头写入。已经存在只 需要先删除这个节点，在写入新的值到头节点。
class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>(capacity);
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);

        } else {

            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);

        }
    }
}