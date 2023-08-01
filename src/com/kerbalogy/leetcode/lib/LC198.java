package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/1 22:01
 * @description
 */
@Run(
        passed = true,
        title = "打家劫舍",
        code = 198
)
public class LC198 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        int[] nums = new int[] {2, 1, 1, 2};
        return rob(nums);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < dp.length; i ++) {

            // 有两种情况：nums[i]偷了，和nums[i]没投
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length - 1];
    }
}
