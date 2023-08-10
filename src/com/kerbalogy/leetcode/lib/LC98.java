package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.TreeNode;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/10 22:59
 * @description
 */
@Run(
        passed = true,
        code = 98,
        title = "二叉树的最大深度",
        everPassed = true,
        comment = "忘了，递归难想，中序简单"
)
public class LC98 extends AbstractLeetcodable<Boolean> {
    @Override
    public Boolean prepareDataAndRun() {
        return null;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return helper(node.left, lower, node.val) && helper(node.right, node.val, upper);
    }
}
