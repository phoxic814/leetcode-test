package leetcode;

import leetcode.domain.TreeNode;

/**
 * no.222
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class InvertReverseTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root;
        root.left = root.right;
        root.right = tmp;
    }
}
