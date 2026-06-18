package Graphs;
import java.util.*;

public class DetectCycleUnDirectedGraph {
    // https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
    // Detect cycle in undirected graph using DFS

    // https://www.youtube.com/watch?v=UrQv5YMC060&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=4
    public boolean isCycle(int V, int[][] edges) {
        // return true if there is cycle, solved by DFS
        // I have to make an adj list first
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            // till V, create a list
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            list.get(v).add(u);

        }
        boolean [] visited = new boolean[V];
        for(int i = 0; i < V; i++) { // we will check for cycle in each component of the graph, if there is a cycle in any component, then we can return true
            if(!visited[i] && dfs(i, list, visited, -1))
                    return true;
        }
        return false;
    }

    public boolean dfs(int node, List<List<Integer>> list, boolean[] visited, int parent){
        // we will check for cycle here in dfs
        visited[node] = true;

        for(int neighbor : list.get(node)) {
            if(parent == neighbor) // if the neighbor is the parent of the current node, then we can skip it because it means that we have already visited the parent node
                continue;

            if(visited[neighbor]) // if the neighbor is already visited and it is not the parent of the current node, then it means that there is a cycle in the graph, so we can return true
                return true;

            if(dfs(neighbor, list, visited, node)) // if the neighbor is not visited, then we will visit it and check for cycle in the neighbor's neighbors, if there is a cycle in the neighbor's neighbors, then we can return true
                return true;
        }
        return false;
    }

    // Example: V = 5, edges = [[0,1],[1,2],[2,0],[3,4]]
    // Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph, because we are visiting each vertex and edge once in the worst case.
    // Space Complexity: O(V) for the visited array and O(V) for the recursion


    // https://www.youtube.com/watch?v=HqIQmKKo5_I&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=6
    // Detect cycle in undirected graph using BFS

    public boolean isCycle2(int V, int[][] edges) {
        // return true if there is cycle, solved by DFS
        // I have to make an adj list first
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            // till V, create a list
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            list.get(v).add(u);

        }
        boolean [] visited = new boolean[V];
        for(int i = 0; i < V; i++) { // we will check for cycle in each component of the graph, if there is a cycle in any component, then we can return true
            if(!visited[i] && bfs(i, list, visited, -1))
                return true;
        }
        return false;
    }

    public boolean bfs(int node, List<List<Integer>> list, boolean[] visited, int parent){
        // we will check for cycle here in bfs
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, parent));
        visited[node] = true;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currentNode = pair.node;
            int currentParent = pair.parent;

            for(int neighbor : list.get(currentNode)) {
                if(neighbor == currentParent) // if the neighbor is the parent of the current node, then we can skip it because it means that we have already visited the parent node
                    continue;
                if(visited[neighbor] && neighbor != currentParent) // if the neighbor is already visited and it is not the parent of the current node, then it means that there is a cycle in the graph, so we can return true
                    return true;

                visited[neighbor] = true;
                queue.add(new Pair(neighbor, currentNode)); // add the neighbor to the queue with the current node as its parent
            }

        }
        return false;
    }

}


class Pair {
    int node;
    int parent;

    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}
