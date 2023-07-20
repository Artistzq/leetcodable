package com.kerbalogy.leetcode.util;

import com.kerbalogy.leetcode.ext.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/17 21:54
 * @description
 */
public class ListNodeUtil {

    public static ListNode from(int[] elems) {
        if (elems.length == 0) {
            return null;
        }

        ListNode head = new ListNode(elems[0], null);
        ListNode p = head;
        for (int i = 1; i < elems.length; i ++) {
            p.next = new ListNode(elems[i], null);
            p = p.next;
        }

        return  head;
    }

    public static String print(ListNode list) {
        ListNode p = list;
        List<String> elems = new ArrayList<>();

        while (p != null) {
            elems.add(String.valueOf(p.val));
            p = p.next;
        }
        return "[" + String.join(",", elems) + "]";
    }

    public static ListNode tail(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }

        ListNode p = list;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

}
