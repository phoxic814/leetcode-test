package leetcode;

import org.junit.Test;

/**
 * NO.45
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    @Test
    public void test() {
        int[] one = {2, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(jump(one));

        int[] two = {0};
        System.out.println(jump(two));
    }

    public int jump(int[] nums) {
        int result = 0;
        // 最後點
        int end = 0;
        // 最大覆蓋區域
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (end >= nums.length - 1) {
                break;
            }

            // 抵達覆蓋, 更新下一步覆蓋
            if (i == end) {
                end = max;
                result++;
            }
        }

        return result;
    }
}
