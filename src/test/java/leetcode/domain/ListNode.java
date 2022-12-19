package leetcode.domain;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getExample(int[] nums) {
        ListNode node = new ListNode();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                node = new ListNode(nums[i], null);
            } else {
                node = new ListNode(nums[i], node);
            }
        }

        return node;
    }

    public void printNode() {
        ListNode nextNode = this;
        while (nextNode != null) {
            System.out.print(nextNode.val + " > ");
            nextNode = nextNode.next;
        }
        System.out.println();
    }
}
