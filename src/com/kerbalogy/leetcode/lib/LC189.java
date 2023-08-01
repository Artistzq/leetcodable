package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;
import com.kerbalogy.leetcode.ext.RawSapce;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/25 20:51
 * @description
 */
@Run(passed = true)
public class LC189 extends AbstractLeetcodable<RawSapce<int[]>> {
    @Override
    protected void setCodeAndTitle() {
        this.code = 189;
        this.title = "轮转数组";
    }

    @Override
    public RawSapce<int[]> prepareDataAndRun() {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        nums = new int[] {1};
        int k = 3;
        rotate(nums, k);
        return new RawSapce<>(nums);
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length - k - 1);
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - 1);
    }

    public void swap(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i ++, j --) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
