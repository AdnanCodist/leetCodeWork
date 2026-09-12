class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {

            // found one
            if (end > intervals[i][0]) { // current start againt prev end. e,g:- 1-4 vs 2-5

                count++;
                end = Math.min(end, intervals[i][1]); // this arrays end or prev end

            } else {
                end = intervals[i][1];
            }
        }

        return count;
        // return
    }
}