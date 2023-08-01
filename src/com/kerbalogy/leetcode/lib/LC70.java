package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/1 21:50
 * @description
 */
@Run(
        passed = true,
        title = "爬楼梯",
        code = 70
)
public class LC70 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        return climbStairs(3);
    }

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int dp0 = 1;
        int dp1 = 2;

        for (int i = 3; i < n + 1; i ++) {
            int dp = dp0 + dp1;
            dp0 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}
