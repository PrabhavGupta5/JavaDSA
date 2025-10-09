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
        static class connectBST {
            public Node connect(Node root) {
                if (root == null) return null;
                Node leftMost = root;

                while (leftMost.left != null) {
                    Node current = leftMost;
                    while (current != null) {
                        current.left.next = current.right;
                        if (current.next != null)
                            current.right.next = current.next.left;
                        current = current.next;
                    }
                    leftMost = leftMost.left;
                }
                return root;
            }
        }
    }

    // https://leetcode.com/problems/binary-tree-right-side-view/
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

                for (int i=0; i < levelSize; i++) {
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