package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.Leetcodable;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.util.ListNodeUtil;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/17 21:50
 * @description
 */
public class LC21 implements Leetcodable<ListNode> {
    @Override
    public ListNode prepareDataAndRun() {
        ListNode list1 = ListNodeUtil.from(new int[] {1,2,4});
        ListNode list2 = ListNodeUtil.from(new int[] {1,3,4});
        ListNode res = mergeTwoLists(list1, list2);
        ListNodeUtil.print(res);
        return  res;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode dummyHead = new ListNode(0, null);
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
