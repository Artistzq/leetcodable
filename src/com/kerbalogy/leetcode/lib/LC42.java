package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.Leetcodable;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/16 13:33
 * @description 接雨水
 */
public class LC42 implements Leetcodable<Integer> {

    @Override
    public Integer prepareDataAndRun() {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        return trap(height);
    }

    public int trap(int[] height) {
        return shuangzhizhen(height);
    }

    public int dandiaozhan(int[] height) {
        /**
         * 对每一个柱子，找右边第一个比它高的，或者一样高的，那这个柱子
         *
         * 找到右边第一个比它高的，就能处理掉中间的积水。
         *
         * 是按层来的。
         * 单调栈解法
         *
         * 要保证栈单调递减。
         */
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        for (int i = 0; i < height.length; i ++) {

            while (! stack.isEmpty() && height[stack.peek()] < height[i]) {
                int midIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int leftIndex = stack.peek();
                int width = i - leftIndex - 1;
                int h = Math.min(height[leftIndex], height[i]) - height[midIndex];

                ans += h * width;
            }
            stack.push(i);
        }

        return ans;
    }

    public int shuangzhizhen(int[] height) {
        /**
         * 可算看懂了，原来双指针同时开两个柱子接水。大家题解没说清楚，害得我也没看懂。 对于每一个柱子接的水，那么它能接的水=min(左右两边最高柱子）-当前柱子高度，这个公式没有问题。同样的，两根柱子要一起求接水，同样要知道它们左右两边最大值的较小值。
         *
         * 问题就在这，假设两柱子分别为 i，j。那么就有 iLeftMax,iRightMax,jLeftMx,jRightMax 这个变量。由于 j>i ，故 jLeftMax>=iLeftMax，iRigthMax>=jRightMax.
         *
         * 那么，如果 iLeftMax>jRightMax，则必有 jLeftMax >= jRightMax，所有我们能接 j 点的水。
         *
         * 如果 jRightMax>iLeftMax，则必有 iRightMax >= iLeftMax，所以我们能接 i 点的水。
         *
         * 而上面我们实际上只用到了 iLeftMax，jRightMax 两个变量，故我们维护这两个即可。（题解都没说清楚，就说个 LeftMax，RightMax，谁知道为什么就可以这么做了。)
         */
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 0, right = height.length - 1;

        int ans = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left ++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                ans += rightMax - height[right];
                right --;
                rightMax = Math.max(rightMax, height[right]);
            }
        }

        return ans;

    }

}
