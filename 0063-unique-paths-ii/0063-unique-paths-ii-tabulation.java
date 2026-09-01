class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if ((grid[n - 1][m - 1] == 1)) {
            return 0;
        }

        int[][] dp = new int[n][m];

        // base case
        dp[n - 1][m - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                // no route in case of honderance
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                // calcilaute

                // final spot (pehle se calculated hai base case);
                if (i == n - 1 && j == m - 1) {
                    continue;
                }

                int right = 0;
                int down = 0;

                if (i + 1 < n) {
                    down = dp[i + 1][j];
                }

                if (j + 1 < m) {
                    right = dp[i][j + 1];
                }

                dp[i][j] = right + down;
            }
        }

        return dp[0][0];
        // return
    }
}