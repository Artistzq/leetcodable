package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/3 22:29
 * @description
 */
@Run(
        passed = true,
        code = 279,
        title = "完全平方数",
        checkSolution = true,
        comment = "简单的做法（贪心）不对，要用dp，完全背包问题"
)
public class LC279 extends AbstractLeetcodable<Integer> {

    @Override
    public Integer prepareDataAndRun() {
        return numSquares(13);
    }

    public int wrongNumSquares(int n) {
        int count = 0;
        while (n != 0) {
            int sqrt = (int) Math.sqrt(n);
            n -= sqrt * sqrt;
            System.out.println(sqrt);
            count ++;
        }
        return count;
    }

    public int numSquares(int n) {
        /**
         * dp[i]表示最少需要多少个数的平方来表示整数i
         *
         * 这些数字落在1, sqrt n之间。枚举这些数。看这些数字最少可以由什么组成
         *
         * 数字j，剩下的数字是？a = i - j*j，如果a能最少，那么i也能最少，且多一个j
         */
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            dp[i] = Integer.MAX_VALUE;
            int sqrtI = (int) Math.sqrt(i);
            for (int j = 0; j <= sqrtI; j ++) {
                dp[i] = Math.min(dp[i - j * j], dp[i]);
            }
            dp[i] += 1;
        }

        return dp[n];

    }
}
