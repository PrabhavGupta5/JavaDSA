package Graphs;

import java.util.ArrayList;
import java.util.List;

public class NoOfCompleteComponents {
    int nodes;
    int noedges;
    public int countCompleteComponents(int n, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        // Building the graph with n nodes, each node will have a list of its neighbors in the graph
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n]; // to keep track of visited nodes during DFS
        int complete = 0; // to count complete components

        // We will iterate through all the nodes, and for each unvisited node, we will perform a DFS to explore the component it belongs to. During the DFS, we will count the number of nodes and edges in that component. After the DFS, we will check if the number of edges is equal to n*(n-1)/2, which is the condition for a complete graph. If it is, we will increment our complete components count.
        for(int i = 0; i < n; i++){
            if(!visited[i]){  // why visited[i] == false? because we are checking if the node is not visited, so we can start a new DFS from that node to explore the component it belongs to
                nodes = 0; // why zero? because we are counting the number of nodes in the current component, so we need to reset it for each new component
                noedges = 0;
                dfs(i, graph, visited);
                noedges = noedges / 2; // because each edge counted twice
                if(noedges == nodes * (nodes - 1) / 2)
                    complete++;
            }
        }
        return complete;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited){
        visited[node] = true; // mark node visited
        nodes++; // count node
        noedges += graph.get(node).size(); // count edges connected to this node

        // Move DFS
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, graph, visited); // visit unvisited neighbors
            }

        }
    }
}
