class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        if (k == 1) {
            return n;
        }

        int[][] tb = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                // palindrome
                if (isPal(s, i, j)) {

                    int next = 1 + ((j + k) < n ? tb[j + 1][j + k] : 0);
                    int grow = tb[i][j + 1];
                    int slide = tb[i + 1][j + 1];

                    tb[i][j] = Math.max(next, Math.max(grow, slide));
                } else {
                    //no pal
                    int grow = tb[i][j + 1];
                    int slide = tb[i + 1][j + 1];

                    tb[i][j] = Math.max(grow, slide);
                }
            }
        }

        return tb[0][k - 1];

    }

    //palindrome hai ???
    public boolean isPal(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}