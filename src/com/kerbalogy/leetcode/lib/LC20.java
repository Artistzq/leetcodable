package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/8/5 18:42
 * @description
 */
@Run(
        passed = true,
        code = 20,
        title = "有效的括号"
)
public class LC20 extends AbstractLeetcodable<Boolean> {
    @Override
    public Boolean prepareDataAndRun() {
        String s = "()";
        return isValid(s);
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') {
                        return false;
                    }
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();
    }
}
