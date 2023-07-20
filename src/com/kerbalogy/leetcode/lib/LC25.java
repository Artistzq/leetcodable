package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.util.ListNodeUtil;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/18 0:06
 * @description
 */
@Run(passed = true)
public class LC25 extends AbstractLeetcodable<ListNode> {

    @Override
    public void setCodeAndTitle() {
        this.code = 25;
        this.title = "K 个一组翻转链表";
    }

    @Override
    public ListNode prepareDataAndRun() {
        ListNode head = ListNodeUtil.from(new int[] {1,2,3,4,5});
        int k = 2;
        k = 3;
        return reverseKGroup(head, k);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // 找到k个节点，
        ListNode dummyHead = new ListNode(0, head);

        ListNode cur = null;
        ListNode pre = dummyHead;

        while (pre.next != null) { // 关键
            // 找到 head 的前一个，和 tail
            // cur从pre开始往后移动n个，就是tail
            cur = pre;
            int i = 0;
            for (; i < k; i ++) {
                if (cur.next == null) { // 关键
                    break;
                }
                cur = cur.next;
            }

            if (i <= k - 1) {
                break;
            }

            // 此时cur停留在要被切断的位置（保留在前），pre在head的前部
            // 记录下关键信息，然后头插
            ListNode tailNext = cur.next;
            ListNode newTail = headInsert(pre, cur);
            newTail.next = tailNext;

            pre = newTail;
        }

        return dummyHead.next;

    }

    public ListNode headInsert(ListNode beforeHead, ListNode tail) {
        // a -> 1 -> 2 -> 3

        ListNode p = beforeHead.next;
        ListNode newTail = p;
        ListNode tailNext = tail.next;
        beforeHead.next = null;

        while (p != tailNext) {

            ListNode temp = p.next;

            p.next = beforeHead.next;
            beforeHead.next = p;

            p = temp;
        }
        return newTail;
    }


}
