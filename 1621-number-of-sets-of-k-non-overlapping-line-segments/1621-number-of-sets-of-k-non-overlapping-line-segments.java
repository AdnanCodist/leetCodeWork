class Solution {
    final static int MOD = 1_000_000_007;

    int n;
    long[][] dp;

    public int numberOfSets(int n, int k) {

        this.n = n;
        dp = new long[n][k + 1];

        for (long[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return (int) solver(0, k);
    }

    // solver
    public long solver(int i, int k) {
        if (k == 0) {
            return 1;
        }

        if (i >= n) {
            return 0;
        }

        if (k > n - 1 - i) {
            return 0;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        long ways = 0;

        // skipping
        ways = (ways + solver(i + 1, k)) % MOD;

        //taking
        for (int j = i + 1; j < n; j++) {
            ways = (ways + solver(j, k - 1)) % MOD;
        }

        return dp[i][k] = ways;
        // return
    }
}