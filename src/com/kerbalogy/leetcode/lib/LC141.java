package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.util.ListNodeUtil;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/20 20:35
 * @description
 */
@Run(passed = true)
public class LC141 extends AbstractLeetcodable<Boolean> {
    @Override
    protected void setCodeAndTitle() {
        this.code = 141;
        this.title = "环形链表";
    }

    @Override
    public Boolean prepareDataAndRun() {
        ListNode head = ListNodeUtil.from(new int[] {3,2,0,-4});
        int pos = 1;
        ListNode p = head;
        for (int i = 0; i <= pos; i ++) {
            if (i == pos) {
                ListNode tail = ListNodeUtil.tail(head);
                tail.next = p;
                break;
            }
            p = p.next;
        }

        return hasCycle(head);

    }

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
