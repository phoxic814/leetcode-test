package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * NO.17
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class PhoneNumber {

    @Test
    public void testSolution() {
        // sample
        String digits = "23";
        System.out.println(letterCombinations(digits));

        // sample
        digits = "";
        System.out.println(letterCombinations(digits));
    }

    // 初始化號碼對應
    private static final String[] phones = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static final StringBuilder tmp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        numAppend(digits, 0, phones, result);
        return result;
    }

    private void numAppend(String digit, int num, String[] phones, List<String> result) {
        // 跑到最後一個數為終止
        if (digit.length() == num) {
            result.add(tmp.toString());
            return;
        }

        String str = phones[digit.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            tmp.append(str.charAt(i));

            // 遞迴直到append最底層
            numAppend(digit, num+1, phones, result);

            // 清除最後一碼繼續拼接
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
