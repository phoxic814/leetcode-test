package leetcode;

import org.junit.Test;

/**
 * no.63
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {

    @Test
    public void test() {
        int[][] one = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0},
        };

        System.out.println(uniquePathsWithObstacles(one));
        System.out.println(solve2(one));
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 起點/終點障礙, 為不可能
        if (grid[0][0] == 1 && grid[m - 1][n - 1] == 1) {
            return 0;
        }

        // m邊界, 障礙後的數值皆為0
        for (int i = 0; i < m && grid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        // m邊界, 障礙後的數值皆為0
        for (int i = 0; i < n && grid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 當格為障礙定義為0
                dp[i][j] = (grid[i][j] == 1) ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    // 空間優化
    public int solve2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j != 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
