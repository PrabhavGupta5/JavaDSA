package DSU;

import java.util.ArrayList;

public class DetectCycleUsingDSU {
    
    public static void main(String[] args) {
        int n = 5; // Number of vertices
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}}; // Edges of the graph

        if (hasCycle(n, edges)) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }

    // if adj list is given then we can use this function to detect cycle in undirected graph using DSU
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] parent = new int[V+1];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for(int u = 0; u < V; u++) {
            for(int v : adj.get(u)) {
                if(u < v) {
                    int pu = find(parent, u);
                    int pv = find(parent, v);
                    if(pu == pv)
                        return true; // Cycle detected

                    union(parent, pu, pv); // Union the two sets
                }
            }
        }

        return false; // No cycle detected
    }


    // for edges, you wont need u < v condition because we are given edges and we will be iterating through all the edges, so we will be checking for all the edges and we will be checking for both u and v
    public static boolean hasCycle(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int parentU = find(parent, u);
            int parentV = find(parent, v);

            if (parentU == parentV) {
                return true; // Cycle detected
            }

            union(parent, parentU, parentV);
        }

        return false; // No cycle detected
    }

    private static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;

        return parent[i] = find(parent, parent[i]); // Path compression
    }

    private static void union(int[] parent, int u, int v) {
        int parentU = find(parent, u);
        int parentV = find(parent, v);

        if(parentU != parentV) {
            parent[parentU] = parentV; // Union, ParentV becomes the parent of ParentU
        }
    }
}
