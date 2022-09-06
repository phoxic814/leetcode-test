package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * NO.15
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    @Test
    public void testSolution() {
        // sample
        int[] one = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(one));

        // sample
        int[] two = {0, 1, 1};
        System.out.println(threeSum(two));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 排序過, 第一個數必須小於0
            if (nums[i] > 0) return resList;

            // 去除迴圈i重複
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 左右指針: 根據總和決定L+1 OR R-1
            int l = i + 1;
            int r = nums.length - 1;
            while (r > l) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    resList.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // 去除重複的值狀況(相鄰值一樣)
                    while (r > l && nums[r] == nums[r - 1]) r--;
                    while (r > l && nums[l] == nums[l + 1]) l++;

                    // next
                    r--;
                    l++;
                }
            }

        }

        return resList;
    }
}
