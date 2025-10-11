package Tree;

public class DFS {

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

    // https://leetcode.com/problems/validate-binary-search-tree/
    // here i used pre order traversal and setting limits to each node val adn checking by recursion

    static class ValidBST {
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean helper(TreeNode node, long min,long max){
            if(node == null)
                return true;

            if(node.val <= min || node.val >= max)
                return false;

            return helper(node.left, min, node.val) && helper(node.right, node.val, max);
        }
    }

    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
    static class FlattenBST {
        public void flatten(TreeNode root) {
            TreeNode current = root;
            while (current != null) {
                if (current.left != null) {
                    TreeNode temp = current.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }

                    temp.right = current.right;
                    current.right = current.left;
                    current.left = null;
                }
                current = current.right;
            }
        }
    }




}
