package leetcode.domain;

/**
 * a graph tree
 *       5
 *   4       6
 * 1   2   7   8
 * <p>
 * 前序(中左右): 5412678, 從父節點優先 traversePreOrder()
 * 中序(左中右): 1425768, 父節點在左到右之間 traverseInOrder()
 * 後序(左右中): 1247865, 父節點最後 traversePostOrder()
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 前序
    public void traversePreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(" " + node.val);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // 中序
    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.val);
            traverseInOrder(node.right);
        }
    }

    // 後序
    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.val);
        }
    }

    private TreeNode addBySequence(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (left == null) {
            current.left = new TreeNode(value);
        } else if (right == null) {
            current.right = new TreeNode(value);
        } else {
            return addBySequence(current.left, value);
        }

        return current;
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.val) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.val) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public static TreeNode createTree(int[] num) {
        TreeNode root = new TreeNode(num[0]);
        for (int i = 1; i < num.length; i++) {
            root.addRecursive(root, num[i]);
        }

        return root;
    }

    public static TreeNode createTreeBySequence(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            root.addBySequence(root, nums[i]);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] num = {5, 4, 6, 1, 2, 7, 8};
        TreeNode tree = createTree(num);
        String s;
    }
}
