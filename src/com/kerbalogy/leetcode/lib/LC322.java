package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/9/4 13:30
 * @description
 */
@Run(
        code = 322,
        title = "零钱兑换"
)
public class LC322 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;
        return coinChange(coins, amount);
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return  -1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j ++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
