package Tree;

import java.util.HashMap;
import java.util.Map;

// This is solved by recursion + memoization
// https://leetcode.com/problems/house-robber-iii/
public class HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        Map<TreeNode, Integer> memo = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) return 0;

            if(memo.containsKey(root)) // give the answer for that root if exists otherwise compute
                return memo.get(root);

            // Case 1: Rob this node
            int rob = root.val;

            if (root.left != null)
                rob += rob(root.left.left) + rob(root.left.right);

            if (root.right != null)
                rob += rob(root.right.left) + rob(root.right.right);

            // Case 2: Skip this node
            int notRob = rob(root.left) + rob(root.right);

            int res = Math.max(rob, notRob);
            memo.put(root, res); // put it into for memoization

            return res;
        }
    }
}
