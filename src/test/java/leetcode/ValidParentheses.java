package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * NO.20
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    @Test
    public void testSolution() {
        // sample
        System.out.println(isValid(("()")));

        //sample
        System.out.println(isValid(("()[]{}")));

        //sample
        System.out.println(isValid(("[")));

        //sample
        System.out.println(isValid(("]")));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '{' || a == '[') {
                stack.push(a);
            } else if (a == ')') {
                char left = stack.empty() ? 0 : stack.pop();
                if (left != '(') return false;
            } else if (a == '}') {
                char left = stack.empty() ? 0 : stack.pop();
                if (left != '{') return false;
            } else if (a == ']') {
                char left = stack.empty() ? 0 : stack.pop();
                if (left != '[') return false;
            }
        }

        return stack.empty();
    }
}
