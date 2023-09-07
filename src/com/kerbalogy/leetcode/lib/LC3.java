package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/1 20:17
 * @description
 */
@Run(
        passed = true,
        title = "无重复字符的最长子串",
        code = 3
)
public class LC3 extends AbstractLeetcodable<Integer> {

    @Override
    public Integer prepareDataAndRun() {
        String s = "abcabcbb";
        s = "bbbbb";
        return lengthOfLongestSubstring(s);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;
        // 窗口：[left, right)内的元素
        while (right < s.length()) {

            while ( set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left ++;
            }

            set.add(s.charAt(right));
            right ++;

            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }
}
