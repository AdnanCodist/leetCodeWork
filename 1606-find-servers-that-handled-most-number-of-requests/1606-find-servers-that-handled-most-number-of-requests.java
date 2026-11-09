class Solution {

    static class Server {
        int freeAt;
        int id;

        Server(int freeAt, int id) {
            this.freeAt = freeAt;
            this.id = id;
        }
    }

    /// main
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int n = arrival.length;

        int[] ans = new int[k];

        TreeSet<Integer> avl = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            avl.add(i);
        }

        PriorityQueue<Server> busy = new PriorityQueue<>(
                (a, b) -> {
                    return a.freeAt - b.freeAt;
                });

        for (int i = 0; i < n; i++) {

            // free occupied severs
            while (!busy.isEmpty() && busy.peek().freeAt <= arrival[i]) {
                Server s = busy.poll();

                avl.add(s.id);
            }

            if (avl.isEmpty())
                continue;

            // rule : i % k;
            Integer pref = avl.ceiling(i % k);

            if (pref == null) {
                pref = avl.first();
            }

            avl.remove(pref);

            ans[pref]++;

            busy.add(new Server(arrival[i] + load[i], pref));

        }

        int max = 0;

        for (int nums : ans) {
            max = Math.max(max, nums);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (ans[i] == max) {
                list.add(i);
            }
        }

        return list;
        // return
    }
}