package LeetCode;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.ArrayList;
import java.util.List;

public class LC24SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = swapPairs(l1);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }

    }

//    public static ListNode swapPairs(ListNode head) {
//        List<ListNode> nodes = new ArrayList<>();
//        while (head != null) {
//            nodes.add(head);
//            head = head.next;
//        }
//        if (nodes.size() >= 2) {
//            ListNode result = new ListNode(-1);
//            ListNode index = result;
//            for (int i = 0; i < (nodes.size() + 1) / 2; i++) {
//                if ((2 * i + 1) < nodes.size()) {
//                    index.next = nodes.get(2 * i + 1);
//                    index = index.next;
//                }
//                index.next = nodes.get(2 * i);
//                index = index.next;
//            }
//            index.next = null;
//            return result.next;
//        } else if (nodes.size() == 1) {
//            return nodes.get(0);
//        } else {
//            return null;
//        }
//    }


    public static ListNode swapPairs(ListNode head) {
        ListNode indexHead = new ListNode(-1);
        indexHead.next = head;
        swap(indexHead);
        return indexHead.next;
    }

    public static void swap(ListNode node) {
        if (node != null && node.next != null && node.next.next != null) {
            ListNode node1 = node.next;
            ListNode node2 = node.next.next;
            ListNode node3 = node.next.next.next;
            node.next = node2;
            node2.next = node1;
            node1.next = node3;
            swap(node1);
        }
    }
}
