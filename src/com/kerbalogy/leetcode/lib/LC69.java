package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/15 20:11
 * @description
 */
@Run(
        passed = true,
        code = 69,
        title = "多数元素",
        comment = "这次终于会了"
)
public class LC69 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        int[] nums = new int[] {2,2,1,1,1,2,2};
//        nums = new int[] {3,2,3};
        return majorityElement(nums);
    }

    public int majorityElement(int[] nums) {
        // 投票法
        if (nums.length == 0) {
            return 0;
        }

        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }

            if (candidate == nums[i]) {
                count ++;
            } else {
                count --;
            }

        }

        return candidate;
    }
}
