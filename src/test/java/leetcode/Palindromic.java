package leetcode;

import org.junit.Test;

/**
 * NO.5
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class Palindromic {

    @Test
    public void testSolution() {
        // sample
        String s = "babad";
        System.out.println(longestPalindrome(s));

        // sample
        s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i<s.length(); i++) {
            // 中心點為1
            String odd = palindromic(s, i, i);
            // 中心點為2
            String even = palindromic(s, i, i+1);
            res = odd.length() > res.length() ? odd : res;
            res = even.length() > res.length() ? even : res;
        }

        return res;
    }

    private String palindromic(String s, int start, int end) {
        String temp = "";
        // 以中心向左右擴散
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            temp = s.substring(start, end + 1);
            start --;
            end ++;
        }

        return temp;
    }
}
