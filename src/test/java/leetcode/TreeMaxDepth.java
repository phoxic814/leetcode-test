package leetcode;

import leetcode.domain.TreeNode;
import org.junit.Test;


/**
 * no.104
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class TreeMaxDepth {

    @Test
    public void test() {
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
