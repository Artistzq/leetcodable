package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.util.ListNodeUtil;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/20 20:17
 * @description
 */
@Run(passed = true)
public class LC206 extends AbstractLeetcodable<ListNode> {
    @Override
    protected void setCodeAndTitle() {
        this.code = 206;
        this.title = "反转链表";
    }

    @Override
    public ListNode prepareDataAndRun() {
        ListNode head = ListNodeUtil.from(new int[] {1,2,3,4,5});
        return reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode p = head;

        while (p != null) {
            ListNode temp = p.next;
            p.next = dummyHead.next;
            dummyHead.next = p;
            p = temp;
        }

        return dummyHead.next;
    }
}
