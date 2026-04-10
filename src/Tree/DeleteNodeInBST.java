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
                    return root.left;
                if(root.left == null)
                    return root.right;

                // case 3: both children are there, we have to take minimum of right subtree to replace that particular node
                TreeNode successor = findMin(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }

            return root;
        }

        public TreeNode findMin(TreeNode root) {
            while(root.left != null) {
                root = root.left;
            }
            return root;
        }
    }
}

// 	1.	Find inorder successor (smallest in right subtree)
//	2.	Replace value
//	3.	Delete successor