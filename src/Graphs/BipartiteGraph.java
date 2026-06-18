package Graphs;
import java.util.*;

// https://leetcode.com/problems/is-graph-bipartite/
// A graph is bipartite if we can split its set of nodes into two independent subsets A and B such that every edge in the graph connects a node in set A and a node in set B.
// Only odd length cycles are not bipartite, even length cycles are bipartite. Every other graph is bipartite. So we can use DFS or BFS to color the graph in two colors, if we find a node that is already colored with the same color as its neighbor, then the graph is not bipartite.
public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        // we will solve using dfs
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        int[] colorArr = new int[n];
        Arrays.fill(colorArr, -1);

        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // create adj list
        for(int i = 0; i < n; i++) {
            for(int neighbor : graph[i]) {
                list.get(i).add(neighbor);
            }
        }

        for(int i = 0; i < n; i++) {
            if(colorArr[i] == -1) {
                if(!dfs(list, colorArr, i, 0))
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(List<List<Integer>> list, int[] colorArr, int currNode, int color){
        colorArr[currNode] = color;

        for(int v : list.get(currNode)){
            if(colorArr[v] == color)
                return false;
            if(colorArr[v] == -1) {
                if(!dfs(list, colorArr, v, 1- color))
                    return false;
            }
        }

        return true;
    }


    // we will solve using bfs

    public boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        int[] colorArr = new int[n];
        Arrays.fill(colorArr, -1);

        for(int i = 0; i<n; i++) {
            if(colorArr[i] == -1) {
                if(!Bfs(graph, i, colorArr, 0))
                    return false;
            }

        }

        return true;
    }

    public boolean Bfs(int[][] graph, int node, int[] colorArr, int currColor) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        colorArr[node] = currColor;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int nei : graph[v]) {
                if (colorArr[nei] == colorArr[v])
                    return false;

                if (colorArr[nei] == -1) {
                    colorArr[nei] = 1 - colorArr[v];
                    q.offer(nei);
                }

            }

        }

        return true;
    }

}
