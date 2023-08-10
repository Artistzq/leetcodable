package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/6 15:37
 * @description
 */
@Run(
        passed = true,
        code = 55,
        title = "跳跃游戏",
        checkSolution = true,
        everPassed = true,
        comment = "实时维护最远位置"
)
public class LC55 extends AbstractLeetcodable<Boolean> {
    @Override
    public Boolean prepareDataAndRun() {
        int[] nums = new int[] {2,3,1,1,4};
        nums = new int[] {3,2,1,0,4};
//        nums = new int[] {0,2,3};
        return canJump(nums);
    }

    public boolean canJump(int[] nums) {
        // 每到一个地方i，有一个最远可到达的位置maxIndex。i <= maxIndex;
        // 然后从i到maxIndex中，挑一个，能使下一个maxIndex最大的位置next
        // 使 i = next，maxIndex = next + nums[next];

        int maxIndex = nums[0];
        for (int i = 0; i < nums.length; i ++) {
            // 要加一个外层的if判断
            if (i <= maxIndex) {
                if (maxIndex >= nums.length - 1) {
                    return true;
                }
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
        }
        return false;
    }
}
