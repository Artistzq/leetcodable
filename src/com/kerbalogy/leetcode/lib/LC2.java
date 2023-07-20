package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.Leetcodable;
import com.kerbalogy.leetcode.ext.ListNode;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/17 21:26
 * @description
 */
public class LC2 implements Leetcodable<ListNode> {
    @Override
    public ListNode prepareDataAndRun() {
        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;

        ListNode newHead = new ListNode(0, null);
        ListNode p = newHead;
        int carray = 0;
        while (p1 != null || p2 != null) {
            int sum = carray;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            int digit = sum % 10;
            carray = sum / 10;

            p.next = new ListNode(digit, null);
            p = p.next;
        }

        // 不能忘了处理carry不是0的情况
        if (carray != 0) {
            p.next = new ListNode(carray, null);
        }

        return newHead.next;
    }
}
