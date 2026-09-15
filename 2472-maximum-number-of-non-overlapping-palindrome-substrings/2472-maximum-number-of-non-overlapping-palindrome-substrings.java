class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        if (k == 1) {
            return n;
        }

        int[][] tb = new int[n + 1][n + 1];

        for (int[] nums : tb) {
            Arrays.fill(nums, -1);
        }

        return solver(s, k, 0, k - 1, tb);
    }

    // solver
    public int solver(String s, int k, int i, int j, int[][] tb) {
        // base-case
        if (i >= s.length() || j >= s.length()) {
            return 0;
        }

        // check memo
        if (tb[i][j] != -1) {
            return tb[i][j];
        }

        // palindrome found
        if (isPal(s, i, j)) {

            int next = 1 + solver(s, k, j + 1, j + k, tb); // tatally a new start
            int grow = solver(s, k, i, j + 1, tb);
            int slide = solver(s, k, i + 1, j + 1, tb);

            return tb[i][j] = Math.max(next, Math.max(grow, slide));
        }

        //htere is no palimdrome
        int grow = solver(s, k, i, j + 1, tb);
        int slide = solver(s, k, i + 1, j + 1, tb);

        return tb[i][j] = Math.max(grow, slide);
        // return
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