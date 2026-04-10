package Tree;

// Just traversing through the tree DFS
// https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertInBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {this.val = val;}
    }

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            // Need to enter val into root
            if(root == null)
                return new TreeNode(val);

            if(val > root.val)
                root.right = insertIntoBST(root.right, val);
            if(val < root.val)
                root.left = insertIntoBST(root.left, val);

            return root;
        }
    }
}
