package Tree;

import java.util.*;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BFS {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int levelSize = q.size();
                List<Integer> currentList = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = q.poll();
                    currentList.add(currentNode.val);

                    if (currentNode.left != null)
                        q.offer(currentNode.left);

                    if (currentNode.right != null)
                        q.offer(currentNode.right);
                }
                res.add(currentList);
            }

            return res;
        }
    }

    // This question is same as BFS level order, but we have to reverse the list for odd levels
    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
    static class zigzagOrder {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            boolean reverseFlag = true;
            if (root == null)
                return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int levelSize = q.size();
                List<Integer> currentList = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = q.poll();
                    currentList.add(currentNode.val);

                    if (currentNode.left != null)
                        q.offer(currentNode.left);

                    if (currentNode.right != null)
                        q.offer(currentNode.right);
                }
                if(!reverseFlag)
                    Collections.reverse(currentList);
                res.add(currentList);
                reverseFlag = !reverseFlag;
            }

            return res;
        }
    }

    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
    // This Question is also basically same as BFS level order, just reverse the list at the end to get bottom up list
    static class BottomUpLevelOrder {
        public List<List<Integer>> levelOrderII(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int levelSize = q.size();
                List<Integer> currentList = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = q.poll();
                    currentList.add(currentNode.val);

                    if (currentNode.left != null)
                        q.offer(currentNode.left);

                    if (currentNode.right != null)
                        q.offer(currentNode.right);
                }
                res.add(currentList);
            }

            Collections.reverse(res);
            return res;
        }
    }


    // This solution is for connect Binary Tree
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//        static class connectBST {
//            public Node connect(Node root) {
//                if (root == null)
//                    return null;
//                if (root.left != null) { // If left is null then right will also be null, so we can check for left only
//                    root.left.next = root.right;  // Across same parent
//                    if (root.next != null) // what is root.next here : root is the current node, root.next is the next node on the same level as root, so if root.next is not null, it means there is a next node on the same level as root, and we can connect root.right to root.next.left to connect across different parents.
//                        root.right.next = root.next.left; // Across different parent // root.next is the next node on the same level as root, and root.next.left is the left child of the next node on the same level as root, so we can connect root.right to root.next.left to connect across different parents.
//                }
//                connect(root.left);
//                connect(root.right);
//                return root;
//            }
//        }

        // In this example: Input: root = [1,2,3,4,5,6,7]
        // for root 2, root.left is 4, root.right is 5, root.next is 3, root.next.left is 6, so we will connect 5 to 6

        // This solution is for connect Binary Tree II
        // https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
        public Node connect(Node root) {
            if (root == null)
                return null;

            Queue<Node> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int levelSize = q.size();
                Node prev = null; // we will use this variable to keep track of the previous node in the level, so that we can connect it to the current node
                for (int i = 0; i < levelSize; i++) {
                    Node currentNode = q.poll();

                    if(prev != null) // for the first node of the level, prev will be null, so we will not connect it to anything, but for the rest of the nodes in the level, we will connect it to the previous node.
                        prev.next = currentNode;

                    prev = currentNode; // after connecting the current node to the previous node, we will update the previous node to be the current node, so that we can connect the next node to it.

                    if (currentNode.left != null)
                        q.offer(currentNode.left);

                    if (currentNode.right != null)
                        q.offer(currentNode.right);
                }
            }

            return root;

        }


        // https://leetcode.com/problems/binary-tree-right-side-view/
        // It is BFS traversal with only returning right side i.e. levelSize - 1 nodes
        static class rightView {
            public List<Integer> rightSideView(TreeNode root) {
                List<Integer> result = new ArrayList<>();

                if (root == null) {
                    return result;
                }

                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);

                while (!queue.isEmpty()) {
                    int levelSize = queue.size();

                    for (int i = 0; i < levelSize; i++) {
                        TreeNode currentNode = queue.poll();

                        if (i == levelSize - 1) {
                            result.add(currentNode.val);
                        }

                        if (currentNode.left != null) {
                            queue.offer(currentNode.left);
                        }
                        if (currentNode.right != null) {
                            queue.offer(currentNode.right);
                        }
                    }
                }
                return result;
            }
        }
    }
}