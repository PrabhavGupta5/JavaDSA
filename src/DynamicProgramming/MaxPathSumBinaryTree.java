package DynamicProgramming;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
// https://www.youtube.com/watch?v=Osz-Vwer6rw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=48&pp=iAQB

public class MaxPathSumBinaryTree {
    public static class TreeNode {
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

    static class Solution {
        int res =Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            solve(root);
            return res;
        }

        public int solve(TreeNode root) {
            if(root == null)
                return 0; // base condition

            int left = solve(root.left); //hypothetical solution
            int right = solve(root.right);

            int temp = Math.max(Math.max(left,right) + root.val, root.val);
            int ans = Math.max(temp, left+right+root.val);
            res = Math.max(res,ans);
            return temp; // returning to the next upper node this temp value
        }
    }
}
