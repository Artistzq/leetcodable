package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

@Run(
        code = 300,
        title = "最长递增子序列",
        passed = true
)
public class LC300 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        nums = new int[] {0,1,0,3,2,3};
        nums = new int[] {7, 7, 7};
        nums = new int[] {1,3,6,7,9,4,10,5,6};
        nums = new int[] {0};
        return lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        /**
         * dp[i]代表以nums[i]结尾的最长递增子序列
         */

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = dp[0];

        for (int i = 1; i < nums.length; i ++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j --) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
