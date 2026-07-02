package Graphs.Dijkstra;
import java.util.*;

// https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // basically source node is k here
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int currDist = curr[1];

            if (currDist > dist[node])
                continue;

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (currDist + weight < dist[nextNode]) {
                    dist[nextNode] = currDist + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }

        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {

            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }

        return max ;

    }
}
