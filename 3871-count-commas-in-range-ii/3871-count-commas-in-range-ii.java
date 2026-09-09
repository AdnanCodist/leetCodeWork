class Solution {
    public long countCommas(long n) {
        long ans = 0;

        for (long x = 1000; x <= n; x *= 1000) {
            ans += n - x + 1; // 1,000 -> 1,000,000 -> 1,000,000,000 .... 10^15
        }

        return ans;
        // return
    }
}