class Solution {
    public int fib(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solver(n, dp);
    }

    public int solver(int n, int[]dp) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] != -1) return dp[n];

        dp[n] = solver(n-1, dp) + solver(n-2, dp);

        return dp[n];
    }
}