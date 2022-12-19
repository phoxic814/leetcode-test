package leetcode;

import org.junit.Test;

/**
 * NO.704
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {

    @Test
    public void test() {
        int[] one = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(one, 9));

        int[] two = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(one, 2));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) { // 比平均大, 縮右邊界
                right = middle - 1;
            } else if (nums[middle] < target) { // 比平均小, 縮左邊界
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
