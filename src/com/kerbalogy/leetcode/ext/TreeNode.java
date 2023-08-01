package com.kerbalogy.leetcode.ext;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/25 21:13
 * @description
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}