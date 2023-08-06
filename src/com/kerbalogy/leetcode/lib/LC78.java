package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/5 15:46
 * @description
 */
@Run(
        passed = true,
        code = 78,
        title = "子集"
)
public class LC78 extends AbstractLeetcodable<List<List<Integer>>> {
    @Override
    public List<List<Integer>> prepareDataAndRun() {
        int[] nums = new int[] {1,2,3};
        nums = new int[] {0};
        return subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(ans, list, nums, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> list, int[] nums, int start) {

        ans.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            dfs(ans, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
