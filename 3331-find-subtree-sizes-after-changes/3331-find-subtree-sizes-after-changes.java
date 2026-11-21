class Solution {

    ArrayList<Integer>[] adj;
    int[] newParent;
    int[] ans;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // form adj lkist
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }
        newParent = new int[n];
        int[] nearest = new int[26];
        Arrays.fill(nearest, -1);

        dfs(0, nearest, parent, s);

        ArrayList<Integer>[] modified = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            modified[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            modified[newParent[i]].add(i);
        }

        ans = new int[n];

        // Calculate subtree sizes
        dfs2(0, modified);

        return ans;
        // reurntr
    }

    public void dfs(int node, int[] nearest, int[] parent, String s) {

        int ch = s.charAt(node) - 'a';

        int currPar = nearest[ch];

        if (node == 0 || nearest[ch] == -1) {
            newParent[node] = parent[node];
        } else {
            newParent[node] = currPar;
        }

        nearest[ch] = node;

        // calln dfs
        for (int child : adj[node]) {
            dfs(child, nearest, parent, s);
        }

        nearest[ch] = currPar;
        // rturn
    }

    // dfs2
    public int dfs2(int node, ArrayList<Integer>[] modified) {

        int size = 1;

        for (int child : modified[node]) {
            size += dfs2(child, modified);
        }

        ans[node] = size;

        return size;
    }
}