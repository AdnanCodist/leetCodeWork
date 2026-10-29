
import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Add ALL zeroes to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                    vis[i][j] = true;
                }
            }
        }

        int[][] directions = {
                { 1, 0 }, // down
                { -1, 0 }, // up
                { 0, 1 }, // right
                { 0, -1 } // left
        };

        // Step 2: Spread BFS from all zeroes
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                // Ignore out-of-bounds or already visited cells
                if (nr < 0 || nr >= n ||
                        nc < 0 || nc >= m ||
                        vis[nr][nc]) {
                    continue;
                }

                ans[nr][nc] = ans[row][col] + 1;
                vis[nr][nc] = true;

                q.offer(new int[] { nr, nc });
            }
        }

        return ans;
    }
}
