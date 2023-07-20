package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.util.ListNodeUtil;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/18 22:31
 * @description
 */
@Run(passed = true)
public class LC148 extends AbstractLeetcodable<ListNode> {
    @Override
    protected void setCodeAndTitle() {
        this.code = 148;
        this.title = "排序链表";
    }

    @Override
    public ListNode prepareDataAndRun() {
        ListNode head = ListNodeUtil.from(new int[] {4,2,1,3});
//        head = ListNodeUtil.from(new int[] {-1,5,3,4,0});
        return sortList(head);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) { // 重要
            return head;
        }

        // 划分
        ListNode fast = head.next; // 重要
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;

        l1 = sortList(l1); // 自赋值很重要
        l2 = sortList(l2);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2;
        ListNode p = dummyHead;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p.next = p2;
                break;
            }

            if (p2 == null) {
                p.next = p1;
                break;
            }

            if (p1.val < p2.val) {
                p.next = p1;
                p = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }
        }

        return dummyHead.next;
    }
}
