
import java.util.*;

class Solution {

    static class Server {
        int weight;
        int index;

        Server(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }

    static class BusyServer {
        long freeAt;
        int weight;
        int index;

        BusyServer(long freeAt, int weight, int index) {
            this.freeAt = freeAt;
            this.weight = weight;
            this.index = index;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {

        int m = servers.length;
        int n = tasks.length;

        int[] ans = new int[n];

        // Available servers: weight -> index
        PriorityQueue<Server> available = new PriorityQueue<>(
                (a, b) -> {
                    if (a.weight != b.weight) {
                        return a.weight - b.weight;
                    }
                    return a.index - b.index;
                });

        // Busy servers: finishing time -> weight -> index
        PriorityQueue<BusyServer> busy = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freeAt != b.freeAt) {
                        return Long.compare(a.freeAt, b.freeAt);
                    }
                    if (a.weight != b.weight) {
                        return a.weight - b.weight;
                    }
                    return a.index - b.index;
                });

        // Initially, all servers are available
        for (int i = 0; i < m; i++) {
            available.offer(new Server(servers[i], i));
        }

        long time = 0;

        for (int i = 0; i < n; i++) {

            time = Math.max(time, i);

            // Release all servers that have finished
            while (!busy.isEmpty() && busy.peek().freeAt <= time) {

                BusyServer s = busy.poll();

                available.offer(new Server(s.weight, s.index));
            }

            // If no server is available, move time forward
            if (available.isEmpty()) {

                time = busy.peek().freeAt;

                while (!busy.isEmpty() && busy.peek().freeAt <= time) {

                    BusyServer s = busy.poll();

                    available.offer(new Server(s.weight, s.index));
                }
            }

            // Select the server with the lowest weight/index
            Server s = available.poll();

            ans[i] = s.index;

            // Calculate when this server will become free
            long finishTime = time + tasks[i];

            busy.offer(new BusyServer(
                    finishTime,
                    s.weight,
                    s.index));
        }

        return ans;
    }
}
