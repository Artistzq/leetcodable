package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.ext.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/4 21:11
 * @description
 */
@Run(
        passed = true,
        comment = "没想到怎么复制随机指针，hashMap？拆分法比较巧妙",
        checkSolution = true
)
public class LC138 extends AbstractLeetcodable<Node> {
    @Override
    public Node prepareDataAndRun() {
        return null;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = node.next;
            newNode.random = node.random == null ? null : node.random.next;
        }
        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node newNode = node.next;
            node.next = newNode.next;
            newNode.next = newNode.next != null ? newNode.next.next : null;
        }
        return newHead;

    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
