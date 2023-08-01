package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.util.ListNodeUtil;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/21 21:02
 * @description
 */
public class LC19 extends AbstractLeetcodable<ListNode> {
    @Override
    protected void setCodeAndTitle() {
        this.code = 19;
        this.title = "删除链表的倒数第N个结点";
    }

    @Override
    public ListNode prepareDataAndRun() {
        ListNode head = ListNodeUtil.from(new int[] {1, 2, 3, 4, 5});
        int n = 2;
        return removeNthFromEnd(head, n);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }
}
