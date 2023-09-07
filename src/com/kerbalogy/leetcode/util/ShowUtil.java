package com.kerbalogy.leetcode.util;

import com.dxy.library.json.jackson.JacksonUtil;
import com.kerbalogy.leetcode.ext.ListNode;
import com.kerbalogy.leetcode.ext.TreeNode;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/25 20:12
 * @description
 */
public class ShowUtil {

    public static void show(Object data) {
        if (data == null) {
            System.out.println("null");
            return;
        }
        if (data.getClass() == TreeNode.class) {
            TreeUtil.inorder((TreeNode) data);
        } else if (data.getClass() == ListNode.class) {
            System.out.println(data);
        } else {
            System.out.println(JacksonUtil.to(data));
        }
    }

}
