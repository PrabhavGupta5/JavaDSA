package Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/description/?envType=problem-list-v2&envId=backtracking
public class PathSumII {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, targetSum, res, new ArrayList<>());
        return res;
    }
    // Basic Idea is I need to TRACK PATH + REDUCE TARGET
    // DFS + backtrack
    public void backtrack(TreeNode root, int target, List<List<Integer>> res, List<Integer> current) {
        if(root == null) return;

        //add
        current.add(root.val);

        // explore
        if(root.left == null && root.right == null && target == 0)  // We are at the leaf node and target is reduced to that root value only
            res.add(new ArrayList<>(current));
        else {
            backtrack(root.left, target - root.val, res, current);
            backtrack(root.right, target - root.val, res, current);
        }

        // remove
        current.remove(current.size() - 1);
    }
}

// At each node:
// 	1.	Add node to path
// 	2.	Reduce target
// 	3.	If leaf + target == 0 → store path
// 	4.	Explore left & right
// 	5.	Backtrack (remove node)
