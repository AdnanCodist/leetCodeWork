


class Pair {
    int row, col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        // Add every initially rotten orange
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }

        int time = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean changed = false;

            for (int k = 0; k < size; k++) {
                Pair p = q.poll();

                int row = p.row;
                int col = p.col;

                for (int d = 0; d < 4; d++) {
                    int nr = row + dr[d];
                    int nc = col + dc[d];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1 &&
                        !vis[nr][nc]) {

                        vis[nr][nc] = true;
                        grid[nr][nc] = 2;

                        q.add(new Pair(nr, nc));
                        changed = true;
                    }
                }
            }

            if (changed) {
                time++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}
