package com.kerbalogy.leetcode.lib;

import com.kerbalogy.leetcode.base.AbstractLeetcodable;
import com.kerbalogy.leetcode.base.Run;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/9/7 17:52
 * @description
 */
@Run(
        code = 394,
        title = "字符串解码"
)
public class LC394 extends AbstractLeetcodable<String> {
    @Override
    public String prepareDataAndRun() {
        String s = "3[a]2[bc]";
        s = "3[a2[c]]";
        return decodeString(s);
    }

    public String decodeString(String s) {
        Deque<Integer> stack = new LinkedList<>();

        StringBuilder ans = new StringBuilder();

        // k, start, end

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '[') {
                stack.push(i);
            } else if (s.charAt(i) == ']') {
                // 取出中间的字符
                int start = 0, end = i - 1;
                while (!stack.isEmpty() && s.charAt(stack.peek()) != '[') {
                    start = stack.pop();
                }
                // 删掉'['
                stack.pop();

                String subs = s.substring(start, end + 1);

                // 取出数字
                int k = 0;
                while (!stack.isEmpty() && s.charAt(stack.peek()) < '9' && s.charAt(stack.peek()) > '0') {
                    k *= 10;
                    k += s.charAt(stack.pop()) - '0';
                }

                // 添加k次，从start到end
                for (int j = 0; j < k; j++) {
                    ans.append(s, start, end + 1);
                }

            } else {
                stack.push(i);
            }
        }

        return ans.toString();
    }
}
