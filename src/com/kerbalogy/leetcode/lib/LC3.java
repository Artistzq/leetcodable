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
        if (s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int length = 1;
        while (right < s.length()) {
            // 如果右边界重复了，则左边界右移
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left ++;
            }
            // 确保加入right后，不会有重复，再加入
            set.add(s.charAt(right));
            right ++;

            length = Math.max(length, set.size());

        }

        return length;
    }
}
