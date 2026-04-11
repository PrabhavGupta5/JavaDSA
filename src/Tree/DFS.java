package Tree;

import java.util.*;

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
    // here I used pre-order traversal and setting limits to each node val and checking by recursion

    static class ValidBST {
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        // here we are taking long because of bigger range

        public boolean dfs(TreeNode root, long min, long max) {
            if (root == null) return true;

            if(root.val <= min || root.val >= max)
                return false;

            boolean left = dfs(root.left, min, root.val); // for left the max we can have value is that root.val, thats why
            boolean right = dfs(root.right, root.val, max);

            return left && right;
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

    /*
Tree:
      3
     / \
    1   4
       /
      5

Steps:
- dfs(3, 3): 3 >= 3 → good = 1 → max = 3
  - dfs(1, 3): 1 < 3 → good = 0 → returns 0
  - dfs(4, 3): 4 >= 3 → good = 1 → max = 4
    - dfs(5, 4): 5 >= 4 → good = 1 → returns 1
    - dfs(4) returns 1 (self) + 1 (left) = 2
- dfs(3) returns 1 (self) + 0 (left) + 2 (right) = 3

Good Nodes = 3 → [3, 4, 5]
*/

    // https://leetcode.com/problems/count-good-nodes-in-binary-tree/

    class Solution {
        public int goodNodes(TreeNode root) {
            // have to track the maximum so far with DFS
            return dfs(root, Integer.MIN_VALUE);
        }

        public int dfs(TreeNode root, int maxSoFar) {
            if(root == null)
                return 0;
            int count = 0;

            if(root.val >= maxSoFar) {
                maxSoFar = root.val;
                count++;
            }

            count = count + dfs(root.left, maxSoFar);
            count = count + dfs(root.right, maxSoFar);

            return count;
        }
    }

    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    static class SerializeAndDeserialize {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            shelper(root, sb);
            return sb.toString();
        }

        public void shelper(TreeNode root, StringBuilder sb ) {
            if(root == null) {
                sb.append("null,");
                return;
            }

            sb.append(root.val).append(",");
            shelper(root.left, sb);
            shelper(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
            return dhelper(queue);
        }

        public TreeNode dhelper(Queue<String> queue) {
            String val = queue.poll();
            if(val.equals("null"))
                return null;
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = dhelper(queue);
            node.right = dhelper(queue);
            return node;
        }
    }


    // https://leetcode.com/problems/path-sum/
    static class PathSum {
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null)
                return false;
            boolean left = hasPathSum(root.left, sum - root.val);
            boolean right = hasPathSum(root.right, sum - root.val);

            if(root.val == sum && root.left == null && root.right == null)
                return true;

            return left || right;
        }
    }
    









}
