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
            if(p.val < root.val && q.val < root.val) {
                // go in the left subtree
                return lowestCommonAncestor(root.left, p, q);
            }
            if(p.val > root.val && q.val > root.val) {
                // go in the right subtree
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }


        // Iterative solution
        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            while (root != null) {
                if (p.val < root.val && q.val < root.val) {
                    root = root.left;
                } else if (p.val > root.val && q.val > root.val) {
                    root = root.right;
                } else {
                    return root;
                }
            }
            return null;
        }

    }
}