package Tree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// https://www.youtube.com/watch?v=cX_kPV_foZc
public class LCAofBST {
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

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;

            if (root.val > p.val && root.val > q.val)
                return lowestCommonAncestor(root.left, p, q);

            if (root.val < p.val && root.val < q.val)
                return lowestCommonAncestor(root.right, p, q);

            return root;
        }

    }
}