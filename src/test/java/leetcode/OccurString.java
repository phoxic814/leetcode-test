package leetcode;

import org.junit.Test;

/**
 * NO.28
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class OccurString {

    @Test
    public void testSolution() {
        // sample
//        int i = strStr("sadbutsad", "sad");
//        System.out.println(i);
//
//        //sample
//        i= strStr("leetcode", "leeto");
//        System.out.println(i);

        //sample
        System.out.println(strStr("aaa", "aaaa"));
    }

    public int strStr(String haystack, String needle) {
        int len = needle.length();
        char first = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            char h = haystack.charAt(i);
            if (h != first || i+len > haystack.length()) continue;
            String sub = haystack.substring(i, i+len);

            if (sub.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
