package Tree;

public class InvertBinaryTree {
    public static class TreeNode {
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

    public static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return null;

            invertTree(root.left);
            invertTree(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            return root;
        }
 // to calculate max depth of a binary tree this below is the solution
        public int maxDepth(TreeNode root) {
            if(root == null)
                return 0;

            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);

            return 1 + Math.max(lh,rh);
        }
    }
}