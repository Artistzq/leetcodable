package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/9/7 15:46
 * @description
 */
@Run(
        code = 155,
        title = "最小栈",
        passed = true
)
public class LC155 extends AbstractLeetcodable<Object> {
    @Override
    public Object prepareDataAndRun() {

        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(0);
        obj.push(3);
        obj.push(0);

        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());

        return null;
    }
}

class MinStack {

    Deque<Long> stack; // 与当前最小值的差值

    int currMin;

    public MinStack() {
        // 存的是和上一个最小值的差值
        stack = new ArrayDeque<>();
        currMin = 0;
    }

    public void push(int val) {

        if (stack.isEmpty()) {
            currMin = val;
            stack.push(0L);
            return;
        }

        // 先插入和上一个最小值的差值
        stack.push((long) val - (long) currMin);

        // 再更新最小值
        currMin = Math.min(val, currMin);

    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        long last = stack.pop();

        if (last < 0) {
            // val 比 上一个min要小，那么现在的min就是val，上一个min通过stack.pop

            // pop(stack_i) = val_i - min_{i-1}
            // min_i = val_i;

            // min_{i-1} = val_i - stack_i = min_i - stack.pop()

            currMin = (int) ((long) currMin - last);
        }
    }

    public int top() {
        if (stack.peek() < 0) {
            return currMin;
        } else {
            return (int)(stack.peek() + currMin);
        }
    }

    public int getMin() {
        return currMin;
    }

}
