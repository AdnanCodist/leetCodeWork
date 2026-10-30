class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        // mark edges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // first and last row
                if (i == 0 || i == n - 1) { // whatever j is
                    if (board[i][j] == 'O') {
                        dfs(i, j, board, vis);
                    }
                }

                // 0th and last col
                if (j == 0 || j == m - 1) { // whatever i is
                    if (board[i][j] == 'O') {
                        dfs(i, j, board, vis);
                    }
                }
            }
        }

        // go ahead mark xs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

        // return
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 ||
                j < 0 ||
                i >= n ||
                j >= m ||
                grid[i][j] == 'X' ||
                vis[i][j] == true) {
            return;
        }

        vis[i][j] = true;

        dfs(i + 1, j, grid, vis); // bottom
        dfs(i - 1, j, grid, vis); // top
        dfs(i, j + 1, grid, vis); // right
        dfs(i, j - 1, grid, vis); // left

        // return
    }
}