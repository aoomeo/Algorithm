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
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
        ListNode result = swapPairs(l1);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }

    }

    public static ListNode swapPairs(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        if (nodes.size() >= 2) {
            ListNode result = new ListNode(-1);
            ListNode index = result;
            for (int i = 0; i < (nodes.size() + 1) / 2; i++) {
                if ((2 * i + 1) < nodes.size()) {
                    index.next = nodes.get(2 * i + 1);
                    index = index.next;
                }
                index.next = nodes.get(2 * i);
                index = index.next;
            }
            index.next = null;
            return result.next;
        } else if (nodes.size() == 1) {
            return nodes.get(0);
        } else {
            return null;
        }
    }

}
