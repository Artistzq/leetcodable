package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.RawSapce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/4 21:33
 * @description
 */
@Run(
        passed = true,
        code = 146,
        title = "LRU缓存",
        comment = "不知道怎么O(1)复杂度"
)
public class LC146 extends AbstractLeetcodable<List<Object>> {
    @Override
    public List<Object> prepareDataAndRun() {
        LRUCache lRUCache = new LRUCache(2);
        List<Object> ans = new ArrayList<>();
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        ans.add(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        ans.add(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        ans.add(lRUCache.get(1));    // 返回 -1 (未找到)
        ans.add(lRUCache.get(3));    // 返回 3
        ans.add(lRUCache.get(4));    // 返回 4
        return ans;
    }
}

class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity;
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> cache;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            // 已经插入，则查找，然后移动到头部
            node.value = value;
            moveToHead(node);
        } else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size ++;
            // 检查是否满了
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size --;
            }
        }
    }

    /**
     * 把节点移动到头部，先删除，再插入到头
     * @param node
     */
    public void moveToHead(DLinkedNode node) {
        addToHead(removeNode(node));
    }

    private void addToHead(DLinkedNode node) {
        // a node b c
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}