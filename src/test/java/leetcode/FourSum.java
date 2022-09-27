package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * no.18
 * https://leetcode.com/problems/4sum/
 * ps: 方法跟ThreeSum一樣, 多一層迴圈
 */
public class FourSum {

    @Test
    public void testSolution() {
        // sample
//        int[] one = {1, 0, -1, 0, -2, 2};
//        System.out.println(fourSum(one, 0));

        int[] two = {2,2,2,2,2};
        System.out.println(fourSum(two, 8));
    }

    // O(n * n * n)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 無資料狀況
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            // 去除相鄰職一樣
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                // 去除迴圈j重複
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 左右指針: 根據總和決定L+1 OR R-1
                int l = j + 1;
                int r = nums.length - 1;

                while (r > l) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        // 去除重複的值狀況(相鄰值一樣)
                        while (r > l && nums[r] == nums[r - 1]) r--;
                        while (r > l && nums[l] == nums[l + 1]) l++;

                        // next
                        r--;
                        l++;
                    }
                }
            }
        }

        return result;
    }
}
