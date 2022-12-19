package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * NO.34
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Note: algorithm with O(log n)
 * prompt: 時間複雜度 log n -> 二分法
 */
public class FirstLastPositionArray {

    @Test
    public void testSolution() {
        int[] one = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(one, 8)));

        int[] two = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(two, 6)));
    }

    public int[] searchRange(int[] nums, int target) {
        int index = findIndex(nums, target);

        if (index == -1) {
            return new int[]{-1, -1};
        }

        int left = index;
        int right = index;

        // 判斷是否有重複值在邊界
        while (left > 0 && nums[left - 1] == nums[left]) {
            left--;
        }

        while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
            right++;
        }

        return new int[] {left, right};
    }

    private int findIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

}
