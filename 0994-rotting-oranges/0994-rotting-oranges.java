class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int ans = 0;

        // store initial rotten idxs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }

        int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } }; // top - bottom - right - left

        while (!q.isEmpty()) {
            boolean happened = false;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                // node coord
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];

                for (int[] dirs : directions) {
                    int nx = x + dirs[0];
                    int ny = y + dirs[1];

                    if (isSafe(nx, ny, n, m) && grid[nx][ny] == 1) {
                        happened = true;
                        grid[nx][ny] = 2;
                        q.add(new int[] { nx, ny });
                    }
                }
            }

            if (happened)
                ans++;
        }

        // final check for unrechable fresh oramge
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return ans;
        // rtetiurn
    }

    // helper
    public boolean isSafe(int i, int j, int n, int m) {
        if (i >= 0 && i < n && j >= 0 && j < m) {
            return true;
        }

        return false;
    }
}