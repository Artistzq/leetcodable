package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/7 19:11
 * @description
 */
public class LC347 extends AbstractLeetcodable<int[]> {
    @Override
    public int[] prepareDataAndRun() {
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        return topKFrequent(nums, k);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> counts = new ArrayList<>(map.entrySet());


        return null ;
    }


    /**
     * pivot左边都比它小，或者等于
     * @param counts
     * @param left
     * @param right
     * @return
     */
    public int partition(List<Map.Entry<Integer, Integer>> counts, int left, int right) {
        Map.Entry<Integer, Integer> entry = counts.get(left);
        int exchangeIdx = left;

        for (int i = left; i < right; i ++) {
            if (entry.getValue() < counts.get(exchangeIdx).getValue()) {
                swap(counts, i, exchangeIdx);
                exchangeIdx ++;
            }
        }

        return exchangeIdx;
    }

    public <T> void swap(List<T> list, int i, int j) {
        T elem = list.get(i);
        list.set(i, list.get(j));
        list.set(j, elem);
    }
}
