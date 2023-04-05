package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * NO.41
 * https://leetcode.com/problems/first-missing-positive/
 * note: O(n) time
 */
public class FirstMissingPositive {

    @Test
    public void testSolution() {
        //sample
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));

        //sample
        int[] nums1 = {0, 2, 2, 1, 1};
        System.out.println(firstMissingPositive(nums));
    }

    // time O(n) space O(n)
    public int firstMissingPositive(int[] nums) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(nums[i]);
        }

        for (int i = 0; i < result.size(); i++) {
            if (!result.contains(i + 1)) return i + 1;
        }

        return result.size() + 1;
    }
}
