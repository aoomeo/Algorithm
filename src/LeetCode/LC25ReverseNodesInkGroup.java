package LeetCode;

import java.util.List;

public class LC25ReverseNodesInkGroup {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode result = reverseKGroup(l1, 6);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode indexHead = new ListNode(-1);
        indexHead.next = head;
        swap(indexHead, k);
        return indexHead.next;
    }

    public static void swap(ListNode head, int k) {
        if (head == null) return;
        ListNode indexNode = head;
        ListNode[] nodes = new ListNode[k];
        //判断后面的节点是否大于k个
        for (int i = 0; i < k; i++) {
            if (indexNode.next == null) {
                return;
            }
            nodes[i] = indexNode.next;
            indexNode = indexNode.next;
        }
        ListNode lastNode = nodes[k - 1].next;
        for (int i = 0; i < k / 2; i++) {
            ListNode x = nodes[i];
            nodes[i] = nodes[k - 1 - i];
            nodes[k - 1 - i] = x;
        }
        for (int i = 0; i < k; i++) {
            head.next = nodes[i];
            head = nodes[i];
        }
        head.next = lastNode;
        swap(head, k);
    }


}
