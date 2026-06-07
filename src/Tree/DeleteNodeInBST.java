package Tree;

// if the key is present, we need to delete that key
//
public class DeleteNodeInBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null)
                return null;

            if(key < root.val)
                root.left = deleteNode(root.left, key);
            if(key > root.val)
                root.right = deleteNode(root.right, key);
            if(key == root.val) {
                // case 1: no Child
                if (root.left == null && root.right == null)
                    return null;

                // case 2: left child or right child
                if(root.right == null)
                    return root.left; // if right child is null then we can return left child to replace the current node
                if(root.left == null)
                    return root.right;

                // case 3: both children are there, we have to take minimum of right subtree to replace that particular node
                // we are basically replacing the value of current node with the successor value
                TreeNode successor = findMin(root.right); // successor is the minimum node in the right subtree of the current node, we can also take maximum of left subtree to replace the current node
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val); // we have to delete the successor node from the right subtree after replacing the value of current node with successor value but why we have to delete the successor node from the right subtree after replacing the value of current node with successor value because we have to maintain the property of binary search tree, if we do not delete the successor node from the right subtree then we will have duplicate values in the right subtree which will violate the property of binary search tree
            }

            return root;
        }

        public TreeNode findMin(TreeNode root) {
            while(root.left != null) {
                root = root.left; // we are going to left until we find the minimum node in the right subtree
            }
            return root;
        }
    }
}

// 	1.	Find inorder successor (smallest in right subtree)
//	2.	Replace value
//	3.	Delete successor

// https://leetcode.com/problems/delete-node-in-a-bst/description/

// example : Input: root = [5,3,6,2,4,null,7], key = 3
// Output: [5,4,6,2,null,null,7]

// In tree format, the above example can be represented as:
//         5
//        / \
//       3   6
//      / \   \
//     2   4   7
