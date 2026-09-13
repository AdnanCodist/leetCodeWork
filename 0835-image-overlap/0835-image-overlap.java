class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans = 0;

        for (int offsetRow = -n + 1; offsetRow < n; offsetRow++) {
            for (int offsetCol = -n + 1; offsetCol < n; offsetCol++) {

                int find = solver(img1, img2, offsetRow, offsetCol);

                ans = Math.max(ans, find);

            }
        }

        return ans;
        // returnb
    }

    // solver
    public int solver(int[][] a, int[][] b, int rowOffset, int colOffset) {
        int n = a.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // b ka offset
                int bi = i + rowOffset;
                int bj = j + colOffset;

                // out of bound
                if (bi < 0 || bj < 0 || bi >= n || bj >= n) {
                    continue;
                }

                // 1 matvh
                if (a[i][j] == 1 && b[bi][bj] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}