package Backtracking;

import java.util.HashMap;

public class PathSumIII {
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

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return backtrack(root, 0, targetSum, map);

    }

    public int backtrack(TreeNode root, long currSum, int target, HashMap<Long, Integer> map) {
        if(root == null) return 0;

        currSum = currSum + root.val;
        int count = map.getOrDefault(currSum-target, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) +1);

        count += backtrack(root.left, currSum, target, map);
        count += backtrack(root.right, currSum, target, map);

        map.put(currSum, map.get(currSum) - 1);

        return count;
    }
}
