package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.util.ListNodeUtil;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/9/4 10:46
 * @description
 */
@Run(
        code = 24,
        title = "两两交换链表中的节点",
        passed = true
)
public class LC24 extends AbstractLeetcodable<ListNode> {
    @Override
    public ListNode prepareDataAndRun() {

        ListNode head = ListNodeUtil.from(new int[] {1, 2, 3, 4});
        ListNodeUtil.print(head);
        return swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null && next != null) {

            // 交换
            curr.next = next.next;
            next.next = curr;
            prev.next = next;

            prev = curr;
            curr = prev.next;
            if (curr == null) {
                break;
            }

            next = curr.next;

        }
        return dummyHead.next;

    }
}
