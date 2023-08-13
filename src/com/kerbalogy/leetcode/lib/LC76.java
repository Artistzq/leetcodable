package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/13 14:09
 * @description
 */
@Run(
        passed = true,
        code = 76,
        title = "最小覆盖字串",
        comment = "滑动窗口，有优化空间",
        checkSolution = true,
        star = 5
)
public class LC76 extends AbstractLeetcodable<String> {
    @Override
    public String prepareDataAndRun() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        return minWindow(s, t);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c: t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int start = 0, len = Integer.MAX_VALUE;

        Map<Character, Integer> sCount = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);

            System.out.println("window: ["+left+","+ right+")");

            while (left <= right && contain(sCount, tCount)) {

                if (right - left < len) {
                    len = right - left;
                    start = left;
                }

                sCount.put(s.charAt(left), sCount.getOrDefault(s.charAt(left), 1) - 1);

                left ++;
            }

            System.out.println("start: " + start + " len: " + len);
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /**
     * s包含t的所有，才返回true
     * t中存在一个s所没有的，就返回false
     * @param sCount
     * @param tCount
     * @return
     */
    public boolean contain(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {
        for (Map.Entry<Character, Integer> entry: tCount.entrySet()) {
            if (! sCount.containsKey(entry.getKey())) {
                return false;
            }

            if (sCount.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
