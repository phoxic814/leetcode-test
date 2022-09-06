package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * NO.1
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    @Test
    public void testSolution() {
        // sample
        int[] one = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(one, 9)));

        // sample
        int[] two = {3,2,4};
        System.out.println(Arrays.toString(twoSum(two, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        // key:要找的value, value:index
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int key = target - nums[i];
            if (numsMap.containsKey(key)) {
                res[1] = i;
                res[0] = numsMap.get(key);
                break;
            }

            numsMap.put(nums[i], i);
        }

        return res;
    }
}
