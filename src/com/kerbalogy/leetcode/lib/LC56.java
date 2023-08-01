package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/25 20:08
 * @description
 */
@Run(passed = true)
public class LC56 extends AbstractLeetcodable<int[][]> {
    @Override
    protected void setCodeAndTitle() {
        this.code = 56;
        this.title = "合并区间";
    }

    @Override
    public int[][] prepareDataAndRun() {
        int[][] intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        intervals = new int[][] {{1, 4}, {4, 5}};
        intervals = new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}};
        return merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 先按照首排序，然后检查。贪心算法
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> inters = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                inters.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        inters.add(new int[] {start, end});
        return inters.toArray(new int[0][0]);
    }
}
