package leetcode;

import org.junit.Test;

import java.util.*;


/**
 * NO.22
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    @Test
    public void testSolution() {
        List<String> list = generateParenthesis(3);
        list.forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        solution(n, n, "", list);
        return list;
    }

    public void solution(int open, int close, String ans, List<String> list) {
        if (open == 0 && close == 0) {
            list.add(ans);
        }

        if (open != 0) {
            solution(open - 1, close, ans + "(", list);
        }

        if(close > open){

            solution(open, close-1,ans+")",list);
        }
    }
}
