class Solution {
    public int findCircleNum(int[][] map) {

        boolean[] vis = new boolean[map.length];

        int ans = 0;

        for (int i = 0; i < map.length; i++) {
            if (!vis[i]) {
                dfs(i, map, vis);
                ans++;
            }
        }

        return ans;
    }

    public void dfs(int node, int[][] map, boolean[] vis) {

        vis[node] = true;

        for (int j = 0; j < map.length; j++) {
            if (map[node][j] == 1 && !vis[j]) {
                dfs(j, map, vis);
            }
        }

        // return
    }
}

/* 

\
class Solution {
    public void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[node][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }
}


*/