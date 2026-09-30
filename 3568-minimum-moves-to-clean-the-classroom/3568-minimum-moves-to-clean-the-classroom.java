import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int n = classroom.length;
        int m = classroom[0].length();

        int startR = 0;
        int startC = 0;

        // Number of trash cells
        int trashCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    trashCount++;
                }
            }
        }

        int fullMask = (1 << trashCount) - 1;

        // Assign a bit to every trash cell
        int[][] trashId = new int[n][m];

        for (int[] row : trashId) {
            Arrays.fill(row, -1);
        }

        int id = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (classroom[i].charAt(j) == 'L') {
                    trashId[i][j] = id++;
                }
            }
        }

        /*
         * State:
         * row, col, energy, mask
         */
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{startR, startC, energy, 0});

        // visited[row][col][energy][mask]
        boolean[][][][] visited =
                new boolean[n][m][energy + 1][1 << trashCount];

        visited[startR][startC][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int e = curr[2];
                int mask = curr[3];

                // All trash collected
                if (mask == fullMask) {
                    return moves;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Outside classroom
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }

                    // Wall
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    // Need energy to move
                    if (e == 0) {
                        continue;
                    }

                    int newEnergy = e - 1;
                    int newMask = mask;

                    char cell = classroom[nr].charAt(nc);

                    // Collect trash
                    if (cell == 'L') {
                        int trash = trashId[nr][nc];
                        newMask |= (1 << trash);
                    }

                    // Recharge
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.offer(new int[]{
                                nr,
                                nc,
                                newEnergy,
                                newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}