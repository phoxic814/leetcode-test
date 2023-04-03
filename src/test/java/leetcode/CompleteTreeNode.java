package leetcode;

import leetcode.domain.TreeNode;
import org.junit.Test;

/**
 * no.222
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CompleteTreeNode {

    @Test
    public void test() {
        int[] num = {4, 2, 5, 1, 6, 3};
        TreeNode node = TreeNode.createTree(num);
        System.out.println(countNodes(node));
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
