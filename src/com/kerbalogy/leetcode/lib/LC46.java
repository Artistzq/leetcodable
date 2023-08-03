package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/3 20:05
 * @description
 */
@Run(
        passed = true,
        title = "全排列",
        code = 46,
        everPassed = true,
        checkSolution = true,
        comment = "检查了题解，好像没错啊。dfs(ans, nums, start + 1); 不是 dfs(..., ..., i + 1)。不是字典序"
)
public class LC46 extends AbstractLeetcodable<List<List<Integer>>> {

    @Override
    public List<List<Integer>> prepareDataAndRun() {
        int[] nums = new int[] {1,2,3};
        return permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, nums, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int[] nums, int start) {
        if (start >= nums.length) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        for (int i = start; i < nums.length; i ++) {
            // 交换
            swap(nums, start, i);
            dfs(ans, nums, start + 1);
            // 交换回来
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
