package leetcode;

import leetcode.domain.TreeNode;
import org.junit.Test;

import static leetcode.domain.TreeNode.createTreeBySequence;


/**
 * NO.101
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    @Test
    public void test() {
        int[] one = {1,2,3};
        System.out.println(isSymmetric(createTreeBySequence(one)));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }

        // 遞迴筆記子節點內外側
        boolean inside = compare(left.left, right.right);
        boolean outside = compare(left.right, right.left);
        return  inside && outside;
    }
}
