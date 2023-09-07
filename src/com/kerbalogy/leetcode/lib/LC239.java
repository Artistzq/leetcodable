package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.Deque;
import java.util.LinkedList;

@Run(
        code = 239,
        title = "滑动窗口最大值",
        passed = true
)
public class LC239 extends AbstractLeetcodable<int[]> {
    @Override
    public int[] prepareDataAndRun() {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;

        nums = new int[] {1, -1};
        k = 1;
        return maxSlidingWindow(nums, k);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i ++) {
            while (! deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i ++) {
            while (! deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            while (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            ans[i - k + 1] = nums[deque.peekFirst()];
        }

        return ans;
    }
}
