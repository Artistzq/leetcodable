package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/31 21:33
 * @description
 */
@Run(
        passed = true,
        everPassed = true,
        checkSolution = true,
        comment = "不能想复杂了"
)
public class LC438 extends AbstractLeetcodable<List<Integer>> {
    @Override
    protected void setCodeAndTitle() {
        this.code = 438;
        this.title = "找到字符串中所有字母异位词";
    }

    @Override
    public List<Integer> prepareDataAndRun() {
        String s = "cbaebabacd";
        String p = "abc";
        s = "abab";
        p = "ab";
        return findAnagrams(s, p);
    }

    public List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口
        int[] counts1 = new int[26];
        for (char c : p.toCharArray()) {
            counts1[c - 'a']++;
        }

        int[] counts = new int[26];
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = 0;

        while (right < s.length()) {

            counts[s.charAt(right) - 'a'] ++;
            right ++;

            while (right - left > p.length()) {
                counts[s.charAt(left) - 'a'] --;
                left ++;
            }

            if (valid(counts, counts1)) {
                ans.add(left);
            }
        }

        return ans;
    }

    private boolean valid(int[] counts, int[] counts2) {
        for (int i = 0; i < counts.length; i ++) {
            if (counts[i] != counts2[i]) {
                return false;
            }
        }
        return true;
    }
}
