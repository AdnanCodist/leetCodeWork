class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solver(0, 0, obstacleGrid, dp);
        // treturn 
    }

    public int solver(int i, int j, int[][] grid, int[][] dp) {

        // past the length
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        // hinderance
        if (grid[i][j] == 1) {
            return 0;
        }

        // reaching end
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        // dp
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solver(i, j + 1, grid, dp);
        int down = solver(i + 1, j, grid, dp);

        return dp[i][j] = right + down;
        // return 
    }
}