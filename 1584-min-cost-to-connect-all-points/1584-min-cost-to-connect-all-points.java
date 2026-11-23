class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        boolean[] vis = new boolean[n];
        int ans;

        q.add(new int[] { 0, 0 });
        int cost = 0;

        while (!q.isEmpty()) {
            int[] peek = q.poll();
            int wt = peek[0];
            int u = peek[1];

            if (vis[u]) {
                continue;
            }

            vis[u] = true;
            cost += wt;

            for (int v = 0; v < n; v++) {
                if (!vis[v]) {
                    int dist = manhattan(points[u], points[v]);
                    q.offer(new int[] { dist, v });
                }
            }
            // end
        }

        return cost;
    }

    public int manhattan(int pta[], int ptb[]) {
        return Math.abs(pta[0] - ptb[0]) + Math.abs(pta[1] - ptb[1]);
    }
}