class Solution {

    int[][] job;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

    job = new int[startTime.length][3];

        for (int i = 0; i < startTime.length; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }

        Arrays.sort(job, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[startTime.length];
        Arrays.fill(dp, -1);

        return solver(0, job, dp);
    }

    // solver
    public int solver(int idx, int[][] job, int[] dp) {
        if (idx == job.length)
            return 0;

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int skip = solver(idx + 1, job, dp);

        int next = nextIdx(job[idx][1]);
        int take = job[idx][2] + solver(next, job, dp);

        return dp[idx] = Math.max(skip, take);
    }

    // bs
    public int nextIdx(int target) {

        int left = 0;
        int right = job.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (job[mid][0] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
        // return
    }
}