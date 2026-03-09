package Graphs;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/all-paths-from-source-to-target/description/
// This problem is solved by using DFS to find all the paths from the source node to the target node.
// We start from the source node and explore all the neighbors recursively until we reach the target node.
// We keep track of the current path and add it to the result list when we reach the target node. We also backtrack to explore
// other paths by removing the last node from the current path after exploring a neighbor.
public class AllPathsFromSourceToTarget {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0); // add the source node to the current path
        dfs(0, graph); // start DFS from the source node (0)
        return res;
    }

    public void dfs(int node, int[][] graph) {
        // Base condition of DFS is when we reach the target node, which is the last node in the graph (graph.length - 1) condition given in question and we add the current path to the result list and return.
        if(node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        // Explore the neighbors of the current node
        for (int neighbor : graph[node]) { // graph[node] gives us the neighbors of the current node
            path.add(neighbor); // add the neighbor to the current path
            dfs(neighbor, graph); // recursively explore the neighbor
            path.removeLast(); // backtrack to explore other paths by removing the last node from the current path after exploring a neighbor
        }
    }
}
