package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.util.ListNodeUtil;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/6 16:37
 * @description
 */
@Run(
        passed = true,
        code = 234,
        title = "回文链表",
        checkSolution = true,
        comment = "删除相近两个相同的做法，失败了；应该快慢指针"
)
public class LC234 extends AbstractLeetcodable<Boolean> {
    @Override
    public Boolean prepareDataAndRun() {
        ListNode head = ListNodeUtil.from(new int[] {1,2,2,1});
        return isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode firstHalfTail = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfTail.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfTail.next = reverseList(secondHalfStart);
        return result;
    }

    public ListNode reverseList(ListNode node) {
        ListNode dummyHead = new ListNode(0);

        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = next;
        }

        return dummyHead.next;
    }

    public ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
