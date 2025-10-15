package Tree;

import java.util.HashMap;
import java.util.Map;

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

        public TreeNode(int rootVal) {
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

    // Construct a binary Tree from Inorder and Preorder
    // 	•	Used the next preorder value as the root,
    //	•	Split the inorder array into left and right subtrees using the root’s index,
    //	•	Recursively constructed left, then right subtrees using updated indices, avoiding array slicing.

    // So the preorderIndex increments like this:
    //Start at root (preorderIndex = 0)
    //Go down left subtree nodes (preorderIndex increments as you pick each root)
    //Once left subtree is fully built, you move on to right subtree nodes
    //This way, preorderIndex always points to the next node to process, moving from leftmost subtree roots to rightmost subtree roots.

    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
    static class Construct {
        private Map<Integer, Integer> inorderMap;
        private int preorderIndex;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
            preorderIndex = 0;
            return helper(preorder, 0, inorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int inorderStart, int inorderEnd) {
            if (inorderStart > inorderEnd) {
                return null;
            }
            int rootVal = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootVal);

            int inorderRootIndex = inorderMap.get(rootVal);

            root.left = helper(preorder, inorderStart, inorderRootIndex - 1);
            root.right = helper(preorder, inorderRootIndex + 1, inorderEnd);

            return root;
        }
    }






}
