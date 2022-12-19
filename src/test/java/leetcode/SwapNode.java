package leetcode;

import leetcode.domain.ListNode;
import org.junit.Test;

/**
 * NO.24
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNode {

    @Test
    public void testSolution() {
        // sample
        int[] nums = {1, 2, 3, 4, 5};
        ListNode node = ListNode.getExample(nums);
        ListNode result = swapPairs(node);
        result.printNode();

        ListNode node1 = ListNode.getExample(nums);
        ListNode result1 = swapPairs1(node1);
        result1.printNode();
    }

    /**
     * 1. dummy -> 2
     * 2. 2 -> 1
     * 3. 1 -> 3
     * note: 1, 3節點會斷掉, 需保留
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            // 保留節點1
            ListNode temp1 = current.next;
            // 保留節點3
            ListNode temp3 = current.next.next.next;

            current.next = current.next.next;
            current.next.next = temp1;
            temp1.next = temp3;

            // 往後移2位
            current = current.next.next;
        }

        return dummy.next;
    }

    // 遞迴法
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode pr = swapPairs1(second.next);
        second.next = head;
        head.next = pr;
        return second;
    }
}
