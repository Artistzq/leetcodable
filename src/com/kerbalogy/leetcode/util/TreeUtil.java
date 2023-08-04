package com.kerbalogy.leetcode.util;

import com.kerbalogy.leetcode.ext.TreeNode;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/25 21:13
 * @description
 */
public class TreeUtil {

    public static TreeNode from(Integer[] nodes) {
        return null;
    }

    public static void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.val + " ");
            inorder(node.right);
        }
    }
}
