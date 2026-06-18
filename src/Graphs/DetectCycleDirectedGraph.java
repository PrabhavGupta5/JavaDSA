package Graphs;

import java.util.*;

public class DetectCycleDirectedGraph {
    // Detect Cycle in Directed Graph using DFS
    // https://www.youtube.com/watch?v=K_LamGUvwUc&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=6&pp=iAQB
    // We can use this same template for course schedule problem, because it is also a directed graph and we have to check for cycle in it, if there is a cycle in the graph, then it means that there is no way to finish all the courses, so we can return false.
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v); // for directed graph, we will only add the edge from u to v, and not from v to u
        }
        boolean[] visited = new boolean[V];
        boolean[] currRecursion = new boolean[V]; // to keep track of the nodes in the current recursion stack

        for (int i = 0; i < V; i++) { // we will check for cycle in each component of the graph, if there is a cycle in any component, then we can return true
            if (!visited[i] && dfs(i, list, visited, currRecursion))
                return true;
        }
        return false;

    }

    public boolean dfs(int node, List<List<Integer>> list, boolean[] visited, boolean[] currRecursion) {
        visited[node] = true;
        currRecursion[node] = true;

        for (int neighbor : list.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, list, visited, currRecursion))
                    return true;
            } else if (currRecursion[neighbor])  // if the neighbor is already visited and it is in the current recursion stack, then it means that there is a cycle in the graph, so we can return true
                return true;
        }

        currRecursion[node] = false;
        return false;
    }

    // visited      -> have we ever visited this node?
    //currRecursion -> is this node in the current DFS path?

    // Undirected Graph:
    //    visited + parent
    //
    // Directed Graph:
    //    visited + recursion stack


    // Detect Cycle in Directed Graph using BFS (Kahn's Algorithm)
    public boolean isCyclicBFS(int V, int[][] edges) {

        List<List<Integer>> list = new ArrayList<>();
        int count = 0; // to keep track of the number of nodes visited in topological sorting

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v); // for directed graph, we will only add the edge from u to v, and not from v to u
        }

        // filling indegree array
        for (int u = 0; u < V; u++) {
            for (int v : list.get(u))
                indegree[v]++;
        }

        // filling queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }

        }

        // starting BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : list.get(node)) {
                indegree[neighbor]--; // we will decrease the indegree of the neighbors of the current node, because we have visited the current node

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor); // if the indegree of a neighbor becomes 0, then we can add it to the queue, because it means that all its dependencies have been visited
                    count++; // we will also increase the count of visited nodes, because we have visited a new node
                }

            }
        }

        if (count == V) // if we have visited all the nodes in the graph, then it means that there is no cycle in the graph, so we can return false
            return false;
        return true; // if we have not visited all the nodes in the graph, then it
    }
}
