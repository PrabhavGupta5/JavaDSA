package Graphs;
import java.util.*;

public class NoOfProvinces {

    // https://leetcode.com/problems/number-of-provinces/
    // We can use DFS to find the number of connected components in the graph. Each connected component will represent a province.
    // We will first convert the given adjacency matrix into an adjacency list representation of the graph. Then we will use a boolean array to keep track of the visited nodes and a count variable to keep track of the number of provinces. We will iterate through each node in the graph and if it is not visited, we will perform a DFS on that node and mark all the nodes in that connected component as visited. After the DFS is complete, we will increment the count variable by 1. Finally, we will return the count variable as the number of provinces.

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && isConnected[i][j] == 1)
                    list.get(i).add(j);
            }
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(i, list, visited);
                count++; // after the DFS is complete, we will increment the count variable by 1, because we have found a new province.
            }
        }

        return count;
    }

    // Most of the time, We dont have to change the DFS function, we can use the same DFS function that we have used in other problems, because the logic of DFS is the same for all problems, we just have to change the way we use it.
    // In this case, we are using DFS to find the number of connected components in the graph, so we will just mark the nodes as visited and increment the count variable after the DFS is complete.
    public void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }


    // Using BFS to find the number of provinces
    public int findCircleNumBFS(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && isConnected[i][j] == 1)
                    list.get(i).add(j);
            }
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                bfs(i, list, visited);
                count++; // after the DFS is complete, we will increment the count variable by 1, because we have found a new province.
            }
        }

        return count;
    }

    public void bfs(int start, List<List<Integer>> graph, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int neighbor : graph.get(node)){

                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
