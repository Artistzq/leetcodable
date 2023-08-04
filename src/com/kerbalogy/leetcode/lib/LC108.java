package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.TreeNode;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/4 20:59
 * @description
 */
@Run(
        passed = true,
        code = 108,
        title = "将有序数组转换为二叉搜索树"
)
public class LC108 extends AbstractLeetcodable<TreeNode> {
    @Override
    public TreeNode prepareDataAndRun() {
        int[] nums = new int[] {-10,-3,0,5,9};
        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        // 要求平衡，从中间开始
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = build(nums, left, mid - 1);
        head.right = build(nums, mid + 1, right);
        return head;
    }
}
