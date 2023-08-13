package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/12 13:22
 * @description
 */
@Run(
        code = 287,
        title = "寻找重复数",
        everPassed = true,
        checkSolution = true,
        comment = "想错了",
        notice = true
)
public class LC287 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        int[] nums = new int[] {1,3,4,2,2};
        return findDuplicate(nums);
    }

    public int findDuplicate(int[] nums) {
        // 全错

        // 把每个数字归位，如果归位的时候发现数字一样就是重复了。

        // 问题：怎么归位？i位置应该是nums[i]，但是不知道nums[i]在哪里啊？
        // 换个思路，整个数组的元素归位，靠的是交换。
        /**
         * nums[i]应该放到i处。什么意思？不对。是 i 应该放在 index=i处
         *
         * index=i处，本来是val=nums[i];
         *
         * 如果nums[i]不是i，则把i放到index=i处，把val=nums[i]拿出来，放到index=val处；
         * 如果nums[val]不是val，就把val放到index=val处，把val=nums[val]处...循环
         * 直到，nums[i]==i，就不用换了，下一格。
         *
         * 那什么时候发现有重复的数字？
         * 就是在切换过程中，发现已经相等了
         */

        // 其实方法不是切换

        return 0;
    }
}
