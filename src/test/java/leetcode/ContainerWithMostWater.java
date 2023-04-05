package leetcode;

import org.junit.Test;
/**
 * NO.11
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    @Test
    public void testSolution() {
        // sample 1
        int[] one = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(one));
    }

    // 長 * 寬 最多
    public int maxArea(int[] height) {
       int l = 0;
       int r = height.length-1;
       int result = 0;

       // l = r, 長為0
       while (l < r) {
           int length = r-l;
           int h = Math.min(height[l], height[r]);
           int area = length * h;
           result = Math.max(result, area);

           // 盡可能找出最大高
           if (height[l] > height[r]) {
               r--;
           } else {
               l++;
           }
       }

       return result;
    }
}
