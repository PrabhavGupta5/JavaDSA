package Graphs;

import java.util.List;

// This question is based on the concept of graph traversal. We can represent the rooms and keys as a graph where each room is a node
// and each key is a directed edge from one node to another. We can use Depth First Search (DFS) to traverse the graph starting from
// room 0 and mark the visited rooms. After the DFS traversal, we can check if all rooms have been visited or not. If all rooms are
// visited, then we can return true, otherwise false.

// Time complexity: O(N + E) where N is the number of rooms and E is the number of keys (edges) in the graph
// Space complexity: O(N) for the visited array and the recursion stack in the worst case

public class KeysRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // here : room = node and key = edge

        // create a visited array to keep track of visited rooms
        boolean[] visited = new boolean[rooms.size()];
        // start dfs from room 0
        dfs(0, rooms, visited);

        // check if all rooms are visited or not
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == false)
                return false;
        }
        return true;
    }

    public void dfs(int roomno, List<List<Integer>> rooms, boolean[] visited) {
        visited[roomno] = true; // mark the current room as visited

        // Move DFS
        for(int key : rooms.get(roomno)){
            if(!visited[key])
                dfs(key, rooms, visited);
        }
    }
}
