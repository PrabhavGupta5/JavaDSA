package DynamicProgramming;

// https://www.youtube.com/watch?v=zmPj_Ee3B8c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=47&pp=iAQB
// https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterBinaryTree {
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

        public int diameterOfBinaryTree(TreeNode root) {
            solve(root);
            return res - 1;
        }

        public int solve(TreeNode root) {
            if(root == null)
                return 0; // base condition

            int left = solve(root.left); //hypothetical solution
            int right = solve(root.right);

            int temp = Math.max(left,right)+1; // to calculate max length for that particular root node
            int ans = left+right+1;
            res = Math.max(res,ans);
            return temp; // returning to the next upper node this temp value
        }
    }
}
