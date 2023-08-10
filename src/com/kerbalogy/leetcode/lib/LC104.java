package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.TreeNode;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/10 22:55
 * @description
 */
@Run(
        passed = true,
        code = 104,
        title = "二叉树的最大深度",
        comment = "简单"
)
public class LC104 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        return null;
    }

    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
