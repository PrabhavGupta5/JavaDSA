package Graphs.Dijkstra;

import java.util.*;

// https://www.youtube.com/watch?v=icVJUN45f1E&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=27
// We will be solving this question by Dijkstra's Algorithm, which is a greedy algorithm that finds the shortest path from a source vertex to all other vertices in the graph. It works by maintaining a priority queue of vertices based on their distance from the source vertex, and repeatedly visiting the vertex with the smallest distance until all vertices have been visited.
public class ShortestPathInWeightedGraph {
    // n is number of vertex, edges is a 2D array where each element is an array of 3 integers representing the two vertices and the weight of the edge between them.
    public List<Integer> shortestPath(int n, int[][] edges) {
        // first need to build adj list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); // because it is an undirected graph
        }

        // we will also maintain a parent array to reconstruct the path from source vertex 0 to destination vertex n-1, because Dijkstra's Algorithm only gives us the distance from the source vertex to all other vertices, but it does not give us the actual path, so we will use the parent array to keep track of the parent of each vertex in the shortest path, so that we can reconstruct the path later.
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        // now we will use Dijkstra's Algorithm to find the shortest path from source vertex 0 to all other vertices
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // we will compare the distance of the vertices in the priority queue to determine their order
        pq.offer(new int[]{0, 0}); // we will add the source vertex to the priority queue with distance 0

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int currDist = curr[1];

            if (currDist > dist[node]) // if the distance of the current vertex is greater than the distance in the dist array, then we can skip it because it means that we have already found a shorter path to this vertex
                continue;

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (currDist + weight < dist[nextNode]) { // if the distance of the current vertex plus the weight of the edge to the neighbor is less than the distance in the dist array, then we have found a shorter path to the neighbor, so we will update the distance in the dist array and add the neighbor to the priority queue with its new distance
                    dist[nextNode] = currDist + weight;
                    parent[nextNode] = node; // we will also update the parent of the neighbor to be the current vertex, so that we can reconstruct the path later
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        // I want to print the path from source vertex 0 to all other vertices, if the distance of a vertex is still Integer.MAX_VALUE, it means that it is not reachable from the source vertex, so we will add -1 to the result list for that vertex, otherwise we will add the distance from the dist array to the result list for that vertex.
        List<Integer> path = new ArrayList<>();
        int node = n - 1;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }

        path.add(0); // we will add the source vertex to the path list, because the while loop will stop when we reach the source vertex, so we need to add it to the path list after the while loop.
        Collections.reverse(path); // we will reverse the path list because we have added the vertices in reverse order, so that the source vertex will be at the end of the list and the destination vertex will be at the beginning of the list, and we want to reverse it to get the correct order of the path from source to destination.

        return path;
    }

}
