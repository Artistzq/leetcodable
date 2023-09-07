package com.kerbalogy.leetcode.lib;

import com.dxy.library.json.jackson.JacksonUtil;
import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.PriorityQueue;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/14 19:44
 * @description
 */
@Run(
        passed = true,
        code = 215,
        title = "数组中的第K个最大元素"
)
public class LC215 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {
        int[] nums = new int[] {3,2,1,5,6,4};
        int k = 2;
        nums = new int[] {3,2,3,1,2,4,5,5,6};
        k = 4;
        return findKthLargest(nums, k);
    }

    public int findKthLargest(int[] nums, int k) {
        // 这里选第n小的元素
        return linearSelect(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    public int linearSelect(int[] nums, int k, int left, int right) {
        int index = partition(nums, left, right);
        if (index == k - 1) {
            return nums[index];
        } else if (index < k - 1) {
            return linearSelect(nums, k, index + 1, right);
        } else {
            return linearSelect(nums, k, left, index - 1);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int exchangedIdx = left;
        int pivot = nums[right];
        for (int i = left; i < right; i++) {
            /**
             * 相等时不会交换，意味着，exchangedIdx的位置，始终严格小于pivot。
             */
            if (nums[i] < pivot) {
                int temp = nums[exchangedIdx];
                nums[exchangedIdx] = nums[i];
                nums[i] = temp;
                exchangedIdx ++;
            }
        }
        // 这个swap不能少
        int temp = nums[exchangedIdx];
        nums[exchangedIdx] = nums[right];
        nums[right] = temp;
        return exchangedIdx;
    }

    public int solution1(int[] nums, int k) {
        // 小顶堆，没挑战
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.peek();
    }
}
