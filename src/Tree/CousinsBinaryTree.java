package Tree;

// https://leetcode.com/problems/cousins-in-binary-tree/
public class CousinsBinaryTree {

    class Solution {
        int xDepth = -1, yDepth = -1;
        BalancedBinaryTree.TreeNode xParent = null, yParent = null;

        public boolean isCousins(BalancedBinaryTree.TreeNode root, int x, int y) {
            dfs(root, null, 0, x, y);
            return (xDepth == yDepth) && (xParent != yParent);
        }

        public void dfs(BalancedBinaryTree.TreeNode root, BalancedBinaryTree.TreeNode parent, int depth, int x, int y) {
            // Base condition
            if(root == null)
                return;

            if(root.val == x) {
                xDepth = depth;
                xParent = parent;
            }

            if(root.val == y) {
                yDepth = depth;
                yParent = parent;
            }

            dfs(root.left, root, depth + 1, x, y);
            dfs(root.right, root, depth + 1, x, y);
        }
    }
}

// We will use DFS to calculate the depth parent must be different
// node → check if x or y
// store → depth + parent
//  recurse → left & right