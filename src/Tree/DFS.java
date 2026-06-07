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
            // what are we doing here
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

        public void flatten2(TreeNode root) {
            if (root == null) return;

            flatten(root.left);
            flatten(root.right);

            TreeNode left = root.left;
            TreeNode right = root.right; // this is my original right subtree that I will attach to the end of the left subtree after I move it to the right side of the current node

            root.left = null; // we are setting root.left to null because we want to flatten the tree into a linked list, which means that all the left child pointers should be null. by setting root.left to null, we are effectively removing the left subtree from the current node and preparing it to be attached to the right side of the current node. this way, we can maintain the structure of a linked list where each node only has a right child, and we can easily connect the left subtree to the right side of the current node without any issues.
            root.right = left; // we are setting root.right to left because we want to move the left subtree to the right side of the current node. by doing this, we are effectively flattening the tree into a linked list structure where all the nodes are connected through their right child pointers. this way, we can maintain the correct order of the nodes in the flattened tree, as the left subtree will now be attached to the right side of the current node, and we can easily connect it to the original right subtree in the next step.

            // so basically curr is traversing to the end of the left subtree that we just moved to the right, so that we can attach the original right subtree to the end of it. this way, we maintain the correct order of the nodes in the flattened tree. by using curr, we can easily find the last node of the left subtree and connect it to the original right subtree, ensuring that all nodes are correctly linked together in a single right-skewed list.
            TreeNode curr = root; // we are using curr to traverse to the end of the left subtree that we just moved to the right, so that we can attach the original right subtree to the end of it. this way, we maintain the correct order of the nodes in the flattened tree. by using curr, we can easily find the last node of the left subtree and connect it to the original right subtree, ensuring that all nodes are correctly linked together in a single right-skewed list.

            while (curr.right != null) {
                curr = curr.right;
            }

            curr.right = right; // after we have moved curr to the end of the left subtree, we attach the original right subtree to it by setting curr.right to right. this ensures that the original right subtree is correctly connected to the end of the left subtree in the flattened tree structure.
        }
    }

    // For Kth Smallest, We will use Inorder Traversal as Inorder traversal always visits nodes from smallest to largest.

//    Summary
//	•	Traverse left subtree.
//	•	Visit current node, increment count.
//            •	If count == k, return this node.
//	•	Otherwise, traverse right subtree.
//	•	Propagate the found node up the recursion to stop further traversal.

    class Solution {
        int ans=0;
        int count=0;

        public int kthSmallest(TreeNode root, int k) {
            inorder(root,k);
            return ans;
        }

        public void inorder(TreeNode root,int k){
            if(root==null)
                return;
            // left root right
            inorder(root.left,k);

            count++;
            if(count==k)
                ans=root.val;

            inorder(root.right,k);
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
    // We are splitting inorder array into two parts
    // “We use inorder to determine subtree boundaries.
    //Elements left of root form the left subtree,
    //elements right form the right subtree.
    //So we recursively build using those index ranges.”
    static class Construct {
        private Map<Integer, Integer> inorderMap;
        private int preorderIndex;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i); // we are storing the index of each value in the inorder array in a hashmap, so that we can quickly find the index of the root value in the inorder array when we are building the tree. this allows us to determine the boundaries of the left and right subtrees without having to search through the inorder array each time, which improves the efficiency of our algorithm.
            }
            preorderIndex = 0;
            return dfs(preorder, 0, inorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int inorderStart, int inorderEnd) {
            if (inorderStart > inorderEnd) // this condition is to check if we have processed all the nodes in the current subtree. if inorderStart is greater than inorderEnd, it means we have gone past the last index of the current subtree in the inorder array, which indicates that there are no more nodes to process in this subtree, so we
                return null;

            int rootVal = preorder[preorderIndex++]; // another way to write this is int rootVal = preorder[preorderIndex]; preorderIndex++; but the way I have written is more concise and easier to read. it is a common pattern in Java to use the post-increment operator (preorderIndex++) when we want to retrieve the current value of preorderIndex and then increment it for the next use. this way, we can get the root value from the preorder array and move on to the next index in one line of code.
            // this will check for every value in the preorder array, and we will use it as the root value for the current subtree we are building. we will then find this root value in the inorder array to determine the boundaries of the left and right subtrees. after processing this root value, we will increment the preorderIndex to move on to the next value in the preorder array for the next recursive calls to build the left and right subtrees.
            TreeNode root = new TreeNode(rootVal);

            int inorderRootIndex = inorderMap.get(rootVal);

            root.left = dfs(preorder, inorderStart, inorderRootIndex - 1);
            root.right = dfs(preorder, inorderRootIndex + 1, inorderEnd);

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

    class Solution2 {
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

            count = count + dfs(root.left, maxSoFar); // we are passing maxSoFar to left and right because we have to compare with the maximum value we have seen so far in the path from root to current node, so that we can count the good nodes correctly. currently we are checking for a path from root to current node, if we find a node that is greater than or equal to the maximum value we have seen so far, then we count it as a good node and update the maximum value. then we pass the updated maximum value to the left and right child nodes, so that they can compare with it and count the good nodes in their respective subtrees.
            count = count + dfs(root.right, maxSoFar);

            return count;
        }
    }

    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    static class SerializeAndDeserialize {

        // what we are doing here is we are using pre-order traversal to serialize the tree, and we are using a queue to deserialize
        // the tree. in the serialize method, we are appending the value of the current node to the string builder, and then we are
        // recursively calling the serialize method for the left and right child nodes. if the current node is null, we are appending
        // "null" to the string builder. in the deserialize method, we are splitting the input string by commas to get an array of
        // node values, and then we are adding them to a queue. we are then recursively calling the deserialize helper method, which
        // will poll values from the queue and construct the tree. if the polled value is "null", we return null. otherwise, we create
        // a new TreeNode with the polled value and recursively call the helper method for its left and right child nodes.
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

        // why pre-order traversal? because we want to ensure that the root node is processed before its children, which allows us to
        // easily reconstruct the tree during deserialization. by using pre-order traversal, we can guarantee that when we encounter
        // a node value during deserialization,
        // we have already processed its parent node, making it straightforward to determine the structure of the tree as we build it
        // back up from the serialized string.

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

        // example tree: Input: root = [1,2,3,null,null,4,5]
        //Output: [1,2,3,null,null,4,5]
    }


    // https://leetcode.com/problems/path-sum/
    // We are reducing the target sum and see if it any time it is equal to root.val
    static class PathSum {
        public boolean hasPathSum(TreeNode root, int target) {
            if(root == null)
                return false;
            boolean left = hasPathSum(root.left, target - root.val);
            boolean right = hasPathSum(root.right, target - root.val);

            if(root.val == target && root.left == null && root.right == null)
                return true;

            return left || right;
        }
    }


    // Maximum Path Sum
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    // what is the intuition behind this solution?
    // The intuition is to calculate the maximum path sum that can be obtained by including the current node and either of its
    // left or right subtrees. We use a post-order traversal to compute the maximum path sum for each node, and we keep track of
    // the global maximum path sum found so far. At each node, we calculate the maximum path sum that can be obtained by including
    // the current node and either of its left or right subtrees, and we update the global maximum path sum if the
    // current path sum is greater than the previously recorded maximum. Finally, we return the global maximum path sum after traversing the entire tree.
    public int dfs(TreeNode root) {
        // return the maximum sum in a node
        if(root == null)
            return 0;
        // why post-order traversal? because we need to calculate the maximum path sum for the left and right subtrees before we can calculate the maximum path sum for the current node. we need to know the maximum path sum for the left and right subtrees in order to determine whether we should include them in the path sum for the current node or not. by using post-order traversal, we ensure that we have already calculated the maximum path sums for the left and right subtrees before we process the current node, which allows us to make informed decisions about whether to include them in the path sum or not.

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        if(leftSum < 0)
            leftSum = 0;
        if(rightSum < 0)
            rightSum = 0;

        int currentSum = root.val + leftSum + rightSum;
        maxSum = Math.max(currentSum, maxSum);

        return root.val + Math.max(leftSum, rightSum);
    }


    // // At each node:
    //	1.	Recursively process left & right
    //	2.	Update children after deletion
    //	3.	Check:
    //	•	If current node is now a leaf
    //	•	AND value == target → delete it

    // Remove leaf nodes from Binary tree equal to target
    // https://leetcode.com/problems/delete-leaves-with-a-given-value/
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;

        root.left = removeLeafNodes(root.left, target); // why root.left = ? because we are updating the left child of the current node after processing it, so that if the left child becomes a leaf node with the target value, we can delete it by setting root.left to null. similarly, we update root.right after processing the right child. this way, we ensure that we are correctly removing any leaf nodes that match the target value from the tree as we traverse it.
        root.right = removeLeafNodes(root.right, target);

        // PostOrder because after deleting children then we will process root.val
        if(root.left == null && root.right == null && root.val == target)
            return null;

        return root;
    }









}
