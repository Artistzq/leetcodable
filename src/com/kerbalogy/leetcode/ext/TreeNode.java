package com.kerbalogy.leetcode.ext;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/25 21:13
 * @description
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}