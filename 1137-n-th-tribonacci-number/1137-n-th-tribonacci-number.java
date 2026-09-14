class Solution {
    public int tribonacci(int n) {

        int[] tb = new int[n+1];
        Arrays.fill(tb, -1);

        return solver(n, tb);
    }

    public int solver(int n, int[] tb) {
        if (n == 2 || n == 1) {
            return 1;
        }

        if (n <= 0) {
            return 0;
        }

        if (tb[n] != -1) {
            return tb[n];
        }

        int p1 = solver(n - 1, tb);
        int p2 = solver(n - 2, tb);
        int p3 = solver(n - 3, tb);

        return tb[n] = p1 + p2 + p3;
    }
}