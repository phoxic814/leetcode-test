package leetcode;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.*;

public class RemoveLinkListNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void testSolution() {
        // sample
        int[] one = {1, 2, 3, 4, 5};
        ListNode listNode = getExample(one);
        ListNode answer = removeNthFromEnd(listNode, 2);
        printNode(answer);

        //sample
        int[] two = {1};
        listNode = getExample(two);
        answer = removeNthFromEnd(listNode, 1);
        printNode(answer);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 創建一個虛擬頭
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 使用快慢節點找出最後n
        ListNode slow = dummy;
        ListNode fast = dummy;

        // 因為我們要刪除節點須操作上一節點, 所以用 >=
        while (n-- > 0) {
            fast = fast.next;
        }

        ListNode ans = null;
        while (fast!= null) {
            ans = slow;
            slow = slow.next;
            fast = fast.next;
        }

        // 刪除slow指向slow.next
        ans.next = slow.next;
        return dummy.next;
    }

    private ListNode getExample(int[] nums) {
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

    private void printNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " > ");
            listNode = listNode.next;
        }
    }
}
