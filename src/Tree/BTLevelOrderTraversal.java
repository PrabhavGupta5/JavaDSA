package Tree;

import java.util.*;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BTLevelOrderTraversal {

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
    static class zigzagOrder {
        public List<List<Integer>> levelOrder(TreeNode root) {
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


}