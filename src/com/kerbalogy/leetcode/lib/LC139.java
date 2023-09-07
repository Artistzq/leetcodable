package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/15 20:21
 * @description
 */
@Run(
        code = 139,
        title = "单词拆分",
        checkSolution = true,
        comment = "动态规划"
)
public class LC139 extends AbstractLeetcodable<Boolean> {
    @Override
    public Boolean prepareDataAndRun() {
        String[] words = new String[] {"leet", "code"};
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(words);
        return wordBreak(s, wordDict);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> sets = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && sets.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
