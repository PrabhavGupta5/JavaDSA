package Graphs.Dijkstra;
import java.util.*;

// Dijkstra's Algorithm is an algorithm for finding the shortest paths between nodes in a graph, which may represent, for example, road networks. It was conceived by computer scientist Edsger W. Dijkstra in 1956 and published three years later.
public class DijkstraAlgo {
    // Time Complexity: O((V + E) log V) where V is the number of vertices and E is the number of edges in the graph. This is because we are using a priority queue to store the vertices based on their resultance from the source vertex, and we are processing each vertex and edge at most once.
    // Space Complexity: O(V) for the distance array and O(V) for the priority queue in the worst case.
    //
    public int[] dijkstra(int V, List<List<int[]>> adj, int src) {

        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // we are using a priority queue to store the vertices based on their distance from the source vertex, so we will compare the resultances of the vertices in the priority queue to determine their order. We will compare the second element of the array (which is the resultance) to determine the order of the vertices in the priority queue.

        result[src] = 0;
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int node = curr[0];
            int currDist = curr[1];

            if (currDist > result[node]) //
                continue;

            for (int[] neighbor : adj.get(node)) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (result[node] + weight < result[nextNode]) {
                    result[nextNode] = result[node] + weight;
                    pq.offer(new int[]{nextNode, result[nextNode]});
                }
            }
        }

        return result;
    }


    // This is an alternative implementation of Dijkstra's Algorithm using a custom Pair class to store the node and its resultance from the source vertex in the priority queue. The logic is the same as the previous implementation.
    static class Solution {
        static class Pair {
            int node;
            int dist;

            Pair(int node, int dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        public int[] dijkstra(int V, List<List<int[]>> adj, int src) {

            int[] result = new int[V];
            Arrays.fill(result, Integer.MAX_VALUE);

            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);

            result[src] = 0;
            pq.offer(new Pair(src, 0));

            while(!pq.isEmpty()) {

                Pair curr = pq.poll();

                int node = curr.node;
                int currDist= curr.dist;

                if(currDist > result[node])
                    continue;

                for(int[] neighbor : adj.get(node)) {

                    int nextNode = neighbor[0];
                    int weight = neighbor[1];

                    if(result[node] + weight < result[nextNode]) {
                        result[nextNode] = result[node] + weight;
                        pq.offer(new Pair(nextNode, result[nextNode]));
                    }
                }
            }

            return result;
        }
    }

}
