package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.util.ListNodeUtil;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/18 23:17
 * @description
 */
@Run(passed = true)
public class LC23 extends AbstractLeetcodable<ListNode> {
    @Override
    protected void setCodeAndTitle() {
        this.code = 23;
        this.title = "合并K个升序链表";
    }

    @Override
    public ListNode prepareDataAndRun() {
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNodeUtil.from(new int[] {1, 4, 5});
        lists[1] = ListNodeUtil.from(new int[] {1, 3, 4});
        lists[2] = ListNodeUtil.from(new int[] {2, 6});

        return mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        for (ListNode list: lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while (!priorityQueue.isEmpty()) {
            ListNode miniNode = priorityQueue.poll();
            p.next = miniNode;

            if (miniNode.next != null) {
                priorityQueue.offer(miniNode.next);
                miniNode.next = null;
            }

            p = p.next;
        }

        return dummyHead.next;
    }
}
