class Solution {
    int n;
    String s;

    int[][] memoRange;
    int[][] memoCost;

    public int minimumChanges(String str, int k) {
        s = str;
        n = s.length();

        memoRange = new int[n][k + 1];
        filler(memoRange);

        memoCost = new int[n][n];
        filler(memoCost);

        return solver(0, k);
    }

    public int solver(int start, int k) {
        // base
        if (k == 0) {
            if (start == n) {
                return 0;
            }

            return Integer.MAX_VALUE;
        }

        // failure case
        if ((start + 2 * k) > n) {
            return Integer.MAX_VALUE;
        }

        //memo
        if (memoRange[start][k] != -1) {
            return memoRange[start][k];
        }

        int minCost = Integer.MAX_VALUE;

        for (int end = start + 1; end < n; end++) {
            int getRest = solver(end + 1, k - 1);

            if (getRest == Integer.MAX_VALUE) {
                continue;
            }

            minCost = Math.min(minCost, getRest + getCost(start, end));
        }

        return memoRange[start][k] = minCost;
        // return 
    }

    public int getCost(int i, int j) {

        if (memoCost[i][j] != -1) {
            return memoCost[i][j];
        }

        int len = j - i + 1;

        int minAns = Integer.MAX_VALUE;

        for (int d = 1; d < len; d++) {

            if (len % d != 0)
                continue;

            int cost = 0;

            for (int group = 0; group < d; group++) {

                int l = i + group;
                int r = l + ((len / d) - 1) * d;

                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        cost++;
                    }

                    l += d;
                    r -= d;
                }

            }

            minAns = Math.min(minAns, cost);
        }

        return memoCost[i][j] = minAns;
        // return
    }

    public void filler(int[][] memo) {

        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
    }
}