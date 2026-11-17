class Solution {

    public int minimumChanges(String s, int k) {

        int n = s.length();
        int INF = 1000000;

        // STAGE 1: Precompute substring costs
        int[][] cost = new int[n][n];

        for (int[] row : cost) {
            Arrays.fill(row, INF);
        }

        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                // Try every valid divisor
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int groupSize = len / d;
                    int changes = 0;

                    // Process all d groups
                    for (int r = 0; r < d; r++) {

                        // Compare mirrored characters
                        for (int t = 0; t < groupSize / 2; t++) {

                            int left = i + r + t * d;

                            int right = i + r
                                    + (groupSize - 1 - t) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    cost[i][i + len - 1] = Math.min(cost[i][i + len - 1], changes);
                }
            }
        }

        // STAGE 2: Partition DP

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Base case
        dp[0][0] = 0;

        // Number of substrings
        for (int p = 1; p <= k; p++) {

            // Prefix length
            for (int i = 2 * p; i <= n; i++) {

                // Starting position of last substring
                for (int start = 2 * (p - 1); start <= i - 2; start++) {

                    if (dp[p - 1][start] == INF) {
                        continue;
                    }

                    dp[p][i] = Math.min(
                            dp[p][i],
                            dp[p - 1][start] + cost[start][i - 1]);
                }
            }
        }

        return dp[k][n];
    }
}
