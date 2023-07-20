package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.Leetcodable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/16 14:49
 * @description
 */
public class LC15 implements Leetcodable<List<List<Integer>>> {

    @Override
    public List<List<Integer>> prepareDataAndRun() {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        return threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        /**
         * 两数之和是nums[k]
         */

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        if (nums[0] > 0) {
            return ans;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left ++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right --;
                    continue;
                }

                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(-target);
                    ans.add(list);

                    left ++;
                    right --;
                } else if (nums[left] + nums[right] < target){
                    left ++;
                } else {
                    right --;
                }
            }
        }

        return ans;
    }
}
