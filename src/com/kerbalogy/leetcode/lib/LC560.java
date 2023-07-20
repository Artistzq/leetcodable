package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.Leetcodable;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/16 16:28
 * @description
 */
public class LC560 implements Leetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {

        int[] nums = new int[] {1,1,1};
        int k = 2;

        return subarraySum(nums, k);

    }

    public int subarraySum(int[] nums, int k) {
        return 0;
    }
}
