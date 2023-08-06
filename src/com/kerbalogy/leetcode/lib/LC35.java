package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/5 17:11
 * @description
 */
@Run(
        passed = true,
        code = 35,
        title = "搜索插入位置"
)
public class LC35 extends AbstractLeetcodable<Integer> {

    @Override
    public Integer prepareDataAndRun() {
        int[] nums = new int[] {1,3,5,6};
        int target = 5;
        target = 2;
        return searchInsert(nums, target);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
