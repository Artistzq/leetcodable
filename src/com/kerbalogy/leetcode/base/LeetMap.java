package com.kerbalogy.leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/20 20:23
 * @description
 */
public class LeetMap {

    private static final Map<Integer, String> leets = new HashMap<>();

    public static Map<Integer, String> add(AbstractLeetcodable<?> leet) {
        leets.put(leet.code, leet.title);
        return leets;
    }

    public static void showALl() {

    }

}
