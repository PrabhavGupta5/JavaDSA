package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 1. Add starting node to queue
//2. Mark it visited
//3. Remove from queue
//4. Visit neighbors
//5. Add unvisited neighbors to queue
// 6. Repeat until queue is empty
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) for the visited array and O(V) for the queue in the worst case.
public class BFSDFS {

    public static void bfs(int start, List<List<Integer>> graph, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){

            int node = queue.poll();
            System.out.print(node + " ");

            for(int neighbor : graph.get(node)){

                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // DFS is similar to BFS, but instead of using a queue, we use recursion to visit neighbors.
    // Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
    // Space Complexity: O(V) for the visited array and O(V) for the recursion
    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
