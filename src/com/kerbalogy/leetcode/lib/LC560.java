package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Leetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/16 16:28
 * @description
 */
@Run(
        passed = true,
        code = 560,
        title = "和为 K 的子数组",
        everPassed = true,
        checkSolution = true,
        comment = "前缀和+哈希表优化，我又忘了"
)
public class LC560 extends AbstractLeetcodable<Integer> {
    @Override
    public Integer prepareDataAndRun() {

        int[] nums = new int[] {1,1,1};
        int k = 2;

        return subarraySum(nums, k);

    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        /**
         * 这一行的作用就是为了应对 nums[0] +nums[1] + ... + nums[i] == k 的情况的, 也就是从下标 0 累加到下标 i, 举个例子说明, 如数组 [1, 2, 3, 6], 那么这个数组的累加和数组为 [1, 3, 6, 12] 如果 k = 6, 假如map中没有预先 put 一个 (0, 1) , 如果此时我们来到了累加和为 6 的位置, 这时map中的情况是 (1, 1), (3, 1), 而 mp.containsKey(pre - k) , 这时 pre - k 也就是 6 - 6 = 0, 因为 map 中没有 (0, 1) 所以 count 的值没有加一, 其实这个时候我们就是忽略了从下标 0 累加到下标 i 等于 k 的情况, 我们仅仅是统计了从下标大于 0 到某个位置等于 k 的所有答案,
         *
         * 至于为什么是 count += mp.get(pre - k); 呢 ? 举个例子: k = 6, 数组 [1, 2, 3, 0, 6] 累加和为: [1, 3, 6, 6, 12], 明显答案应该是 4, 当我们来到第一个累加和为 6 的位置上时, pre - k = 0, 也就是说从下标 0 到当前位置的累加和是一个答案, 当来到第二个 6 的位置上时, 也就是说从下标 0 到当前位置的累加和是一个答案, 而当来到 12 位置上时, pre - k = 6, 也就是说从累加和为 6 的子数组的后一个位置到当前位置也是满足条件的答案, 而累加和为 6 的子数组只有一个吗 ? 不 ! 这个例子中他有两个, 所以 count 是 加 mp.get(pre - k);, 而不是加 1,
         *
         * 如果说 mp.put(0, 1); 不好理解, 那么我们也可以换一种思路, 这个东西不就是为了统计从下标 0 到下标 i 累加和刚好等于 k 吗, 那我们可以在累加和刚好等于 k 的时候直接给count + 1, 剩下的操作该怎么样还怎么样,
         */
        map.put(0, 1);

        for (int i = 0; i < nums.length; i ++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
