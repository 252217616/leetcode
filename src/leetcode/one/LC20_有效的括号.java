package leetcode.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LC20_有效的括号
 *
 * @author lujun
 * @date 2022/5/9
 */
public class LC20_有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                left.push(c);
            } else // 字符 c 是右括号
                if (!left.isEmpty() && leftOf(c) == left.peek()) {
                    left.pop();
                } else {
                    // 和最近的左括号不匹配
                    return false;
                }
        }
        // 是否所有的左括号都被匹配了
        return left.isEmpty();
    }

    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';

    }
}