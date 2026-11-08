class Solution {
    int n;
    int m;

    public int countServers(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] != 0) {
                    if (searchRow(grid, i, j, grid[i][j]) || searchCol(grid, i, j, grid[i][j])) {
                        ans++;
                    }
                }
                // end
            }
        }

        return ans;
        // return
    }

    // sear4ch row
    public boolean searchRow(int[][] grid, int row, int col, int num) {
        for (int i = 0; i < n; i++) {
            if (i == row)
                continue;

            if (grid[i][col] == num)
                return true;
        }

        return false;
    }

    // search cols
    public boolean searchCol(int[][] grid, int row, int col, int num) {
        for (int i = 0; i < m; i++) {
            if (i == col)
                continue;

            if (grid[row][i] == num)
                return true;
        }

        return false;
    }
}