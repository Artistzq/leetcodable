package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/3 21:48
 * @description
 */
@Run(
        passed = true,
        code = 121,
        title = "买卖股票的最佳时机",
        comment = "还是差了点，还有贪心法没试过，注意重点：只能买卖一次"
)
public class LC121 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        int[] nums = new int[] {7,1,5,3,6,4};
        return maxProfit(nums);
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 对于某天，有股票 0， 没股票 1
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i ++) {
            dp[i][0] = Math.max(dp[i-1][0], - prices[i]); // 这里是重点！不是dp[i-1][1]-prices[i]
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][1]);
        }

        return dp[prices.length - 1][1];
    }
}
