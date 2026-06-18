package Graphs;
import java.util.*;

public class CourseScheduleII {
    // https://leetcode.com/problems/course-schedule-ii/
    // BFS Topological Sorting
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        int count = 0; // to keep track of the number of nodes visited in topological sorting

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            list.get(v).add(u); // for directed graph, we will only add the edge from u to v, and not from v to u
        }

        // filling indegree array
        for (int u = 0; u < numCourses; u++) {
            for (int v : list.get(u))
                indegree[v]++;
        }

        // filling queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }

        }

        // starting BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);


            for (int neighbor : list.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                    count++;
                }

            }
        }

        if (count == numCourses)
            return res.stream().mapToInt(Integer::intValue).toArray();
        return new int[]{};

    }
}
