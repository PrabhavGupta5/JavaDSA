package Tree;

public class DepthBinaryTree {

    public static int depth(BFS.Node root) {
        // base condition: if the root is null, then the depth is 0
        if(root == null)
            return 0;
        // hypothesis: left and right subtrees are giving us the correct depth
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        // induction step: we will take the maximum of the left and right depth and add 1 to it to account for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
