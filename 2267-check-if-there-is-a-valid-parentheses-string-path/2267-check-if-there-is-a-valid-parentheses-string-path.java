class Solution {
    public boolean hasValidPath(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int maxLen = rows + cols - 1;

        int[][][] dp = new int[rows][cols][maxLen];

        for (int[][] arr : dp) {
            for (int[] nums : arr) {
                Arrays.fill(nums, -1);
            }
        }

        return solver(grid, 0, 0, 0, dp) == 0 ? true : false;
    }

    public int solver(char[][] grid, int i, int j, int cnt, int[][][] dp) {

        // i -> rows ke liye 
        // j -> cols ke liye
        // counting mechanism 

        if (grid[i][j] == '(')
            cnt++;
        if (grid[i][j] == ')')
            cnt--;

        // negative check
        if (cnt < 0)
            return 1;

        if (i == grid.length - 1
                &&
                j == grid[0].length - 1) {

            if (cnt == 0)
                return 0;

            return 1; // not a path
        }

        if (dp[i][j][cnt] != -1) {
            return dp[i][j][cnt];
        }

        int bottom = 1;
        int right = 1;

        if (i + 1 < grid.length) {
            bottom = solver(grid, i + 1, j, cnt, dp);

        }

        if (j + 1 < grid[0].length) {
            right = solver(grid, i, j + 1, cnt, dp);

        }

        return dp[i][j][cnt] = (bottom == 0 || right == 0) ? 0 : 1;
        // end
    }
}