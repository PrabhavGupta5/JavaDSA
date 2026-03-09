package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/clone-graph/description/
// This problem is solved by using a HashMap to store the mapping of the original node to the cloned node.
// We use DFS to traverse the graph and clone the nodes and their neighbors.
// Time complexity: O(N) where N is the number of nodes in the graph
// Space complexity: O(N) for the HashMap and the recursion stack

public class CloneGraph {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    static class Solution {
        HashMap<Node, Node> map = new HashMap<>();
        public Node cloneGraph(Node node) {

            // base case
            if (node == null)
                return null;

            // if the node is already cloned, return the cloned node from the map
            if (map.containsKey(node))
                return map.get(node); // returns the cloned value

            // clone the node and put it in the map
            Node clone = new Node(node.val);
            map.put(node, clone);

            // clone the neighbors recursively and add them to the cloned node's neighbors list cuz cloneGraph(neighbor) will return the cloned neighbor, and we are adding it to the neighbors list of the cloned node
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(cloneGraph(neighbor));
            }

            return clone;
        }
    }
}