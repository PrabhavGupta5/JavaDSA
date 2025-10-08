package Tree;

// https://leetcode.com/problems/subtree-of-another-tree/
public class SubTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode subtree) {
            if (s == null) return false;
            if (isSame(s, subtree)) return true;
            // This recursion call is to check for every child node if the root does not match with subtree
            return isSubtree(s.left, subtree) || isSubtree(s.right, subtree);
        }

        private boolean isSame(TreeNode s, TreeNode subtree) {
            if (s == null && subtree == null) return true;
            if (s == null || subtree == null) return false;

            if (s.val != subtree.val) return false;

            return isSame(s.left, subtree.left) && isSame(s.right, subtree.right);
        }
    }
}