package Graphs;
import java.util.*;

// https://youtu.be/WbbYZRr4arw?si=BytPaIVTESiwOJKf
public class TopologicalSorting {
    // Topological Sorting is a linear ordering of vertices in a directed acyclic graph (DAG) such that for every directed edge uv from vertex u to vertex v, u comes before v in the ordering. It is used to solve problems like task scheduling, course prerequisite, etc.
    // Topological Sorting can be done using DFS or Kahn's Algorithm (BFS). Here, we will implement Topological Sorting using DFS.
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++) {
            // till V, create a list
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);

        }
        boolean [] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i])
                dfs(i, list, visited, st);
        }

        while(!st.isEmpty()){ // we will pop from the stack and add to the result list, because the nodes will be in reverse order in the stack, so we will get the correct topological order when we pop from the stack.
            res.add(st.pop());

        }
        return res;
    }

    public void dfs(int node, List<List<Integer>> list, boolean[] visited, Stack<Integer> st){
        visited[node] = true;

        for(int neighbor : list.get(node)) {
            if(!visited[neighbor])
                dfs(neighbor, list, visited, st);
        }

        st.push(node); // push the parent node after visiting all its neighbors, so that the parent node will be on top of the stack and the neighbors will be below it, which will give us the correct topological order when we pop from the stack.
    }




    // Topological Sorting using Kahn's Algorithm (BFS)
    class Solution {
        public ArrayList<Integer> topoSort(int V, int[][] edges) {
            // code here
            List<List<Integer>> list = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();

            for(int i = 0; i < V; i++) {
                // till V, create a list
                list.add(new ArrayList<>());
            }
            for(int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                list.get(u).add(v);
            }
            int[] indegree = new int[V];
            // 1. have to fill indegree array

            for(int u = 0; u < V; u++) {
                for(int v : list.get(u))
                    indegree[v]++;
            }

            // 2. put indegree == 0 to queue
            for(int i = 0; i < V; i++) {
                if(indegree[i] == 0)
                    q.offer(i);
            }


            // 3. Simple BFS traversal
            while (!q.isEmpty()) {
                int node = q.poll();
                res.add(node);


                for(int v : list.get(node)) {
                    indegree[v]--;

                    if(indegree[v] == 0)
                        q.offer(v);
                }
            }

            return res;
        }


    }
}
