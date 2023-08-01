package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/1 21:26
 * @description
 */
@Run(
        passed = true,
        title = "杨辉三角",
        code = 118,
        comment = "逻辑写复杂了"
)
public class LC118 extends AbstractLeetcodable<List<List<Integer>>> {
    @Override
    public List<List<Integer>> prepareDataAndRun() {
        return generate(1);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            ans.add(list);
            return ans;
        }
        if (numRows == 2) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            ans.add(list);
            list = new ArrayList<>();
            list.add(1);
            list.add(1);
            ans.add(list);
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        ans.add(list);
        for (int i = 3; i <= numRows; i ++) {
            list = new ArrayList<>(i);
            list.add(1);
            for (int j = 1; j < i-1; j ++) {
                List<Integer> lastRow = ans.get(i - 2);
                list.add(lastRow.get(j-1) + lastRow.get(j));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}
