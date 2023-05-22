package leetcode;

import org.junit.Test;

/**
 * no.62
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    @Test
    public void test() {
        // one
        System.out.println(uniquePaths(3, 2));
    }

    /**
     * 1.定義公式 dp[m-1][j] + dp[m][j-1]
     * 2.定義邊界 dp[0][j] = 1, dp[i][0] = 1
     * O(n*n)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // m邊界
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // m邊界
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
