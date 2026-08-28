import java.util.*;

class Solution {

    long MOD = 1_000_000_007L;
    long[] dp;

    public int numDecodings(String s) {

        int n = s.length();

        dp = new long[n];

        Arrays.fill(dp, -1);

        return (int) solve(s, 0);
    }

    public long solve(String s, int i) {

        // Successfully decoded the entire string
        if (i == s.length()) {
            return 1;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        long ways = 0;

        char first = s.charAt(i);

        // -------------------------
        // Take ONE character
        // -------------------------

        if (first == '*') {

            // * can be 1,2,3,...9
            ways += 9 * solve(s, i + 1);

        } else if (first != '0') {

            // 1-9 has exactly one possibility
            ways += solve(s, i + 1);
        }

        // -------------------------
        // Take TWO characters
        // -------------------------

        if (i + 1 < s.length()) {

            char second = s.charAt(i + 1);

            if (first == '*' && second == '*') {

                ways += 15 * solve(s, i + 2);

            } else if (first == '*') {

                if (second >= '0' && second <= '6') {
                    ways += 2 * solve(s, i + 2);
                } else {
                    ways += solve(s, i + 2);
                }

            } else if (second == '*') {

                if (first == '1') {
                    ways += 9 * solve(s, i + 2);
                } else if (first == '2') {
                    ways += 6 * solve(s, i + 2);
                }

            } else {

                int num = (first - '0') * 10 + (second - '0');

                if (num >= 10 && num <= 26) {
                    ways += solve(s, i + 2);
                }
            }
            // end
        }

        return dp[i] = ways % MOD;
    }
}