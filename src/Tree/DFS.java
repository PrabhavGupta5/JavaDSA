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
    // here I used pre-order traversal and setting limits to each node val adn checking by recursion

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

    // For Kth Smallest, We will use Inorder Traversal as Inorder traversal always visits nodes from smallest to largest.

//    Summary
//	•	Traverse left subtree.
//	•	Visit current node, increment count.
//            •	If count == k, return this node.
//	•	Otherwise, traverse right subtree.
//	•	Propagate the found node up the recursion to stop further traversal.

    static class KthSmallest {
        int count = 0;
        public int kthSmallest(TreeNode root, int k) {
            return helper(root, k).val;
        }

        public TreeNode helper(TreeNode root, int k) {
            if (root == null)
                return null;
            TreeNode left = helper(root.left, k);
            if (left != null)
                return left;   // if the kth smallest element has been found in the left subtree, return it immediately.
            count++;
            if(count == k)
                return root;

            return helper(root.right, k);
        }
    }






}
