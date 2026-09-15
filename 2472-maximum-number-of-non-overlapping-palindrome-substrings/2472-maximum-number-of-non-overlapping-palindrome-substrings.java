class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        if (k == 1)
            return n;

        boolean[][] pal = new boolean[n][n];

        // Palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)
                        && (j - i <= 2 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }

        int[][] tb = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int grow = tb[i][j + 1];
                int slide = tb[i + 1][j + 1];

                // Palindrome of required length found
                if (pal[i][j] && j - i + 1 >= k) {

                    int next = 1;

                    if (j + k < n) {
                        next += tb[j + 1][j + k];
                    }

                    tb[i][j] = Math.max(
                        next,
                        Math.max(grow, slide)
                    );

                } else {

                    tb[i][j] = Math.max(grow, slide);
                }
            }
        }

        return tb[0][k - 1];
    }
}