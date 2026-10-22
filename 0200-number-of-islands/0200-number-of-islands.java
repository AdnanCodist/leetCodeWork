class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    search(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    // search
    public void search(char[][] grid, int i, int j) {
        if (i < 0 ||
                j < 0 ||
                i >= grid.length ||
                j >= grid[0].length ||
                grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        search(grid, i + 1, j); // bottom 
        search(grid, i - 1, j); // top 
        search(grid, i, j + 1); // right
        search(grid, i, j - 1); // left

        /// return
    }
}

/*

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);

    }
}

*/