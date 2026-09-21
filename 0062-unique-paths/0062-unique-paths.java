class Solution {
    public int uniquePaths(int m, int n) {

        // tryinpg bottom up 
        int[] curr = new int[m];
        int[] down = new int[m];

        // base case for row
        for (int i = 0; i < m; i++) {
            down[i] = 1;
        }

        curr[m - 1] = 1;

        // finds
        for (int i = n - 2; i >= 0; i--) {
            curr[m - 1] = 1;
            for (int j = m - 2; j >= 0; j--) {
                curr[j] = curr[j+1] + down[j];
            }

            down = curr.clone();
        }

        return down[0];
        // return
    }
}