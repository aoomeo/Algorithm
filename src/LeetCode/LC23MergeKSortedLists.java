package LeetCode;

import java.util.List;

public class LC23MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-10);
        ListNode l1n1 = new ListNode(-9);
        ListNode l1n2 = new ListNode(-9);
        ListNode l1n3 = new ListNode(-3);
        ListNode l1n4 = new ListNode(-1);
        ListNode l1n5 = new ListNode(-1);
        ListNode l1n6 = new ListNode(0);
        l1.next = l1n1;
        l1n1.next = l1n2;
        l1n2.next = l1n3;
        l1n3.next = l1n4;
        l1n4.next = l1n5;
        l1n5.next = l1n6;
        ListNode l2 = new ListNode(-5);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(-8);
        ListNode l5 = null;
        ListNode l6 = new ListNode(-9);
        ListNode l6n1 = new ListNode(-6);
        ListNode l6n2 = new ListNode(-5);
        ListNode l6n3 = new ListNode(-4);
        ListNode l6n4 = new ListNode(-2);
        ListNode l6n5 = new ListNode(2);
        ListNode l6n6 = new ListNode(3);
        l6.next = l6n1;
        l6n1.next = l6n2;
        l6n2.next = l6n3;
        l6n3.next = l6n4;
        l6n4.next = l6n5;
        l6n5.next = l6n6;
        ListNode l7 = new ListNode(-3);
        ListNode l7n1 = new ListNode(-3);
        ListNode l7n2 = new ListNode(-2);
        ListNode l7n3 = new ListNode(-1);
        ListNode l7n4 = new ListNode(0);
        l7.next = l7n1;
        l7n1.next = l7n2;
        l7n2.next = l7n3;
        l7n3.next = l7n4;
        ListNode[] a = new ListNode[]{l1, l2, l3, l4, l5, l6, l7};
        ListNode result = mergeKLists(a);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return lists.length == 0 ? null : sortDouble(lists, 0, lists.length - 1);
    }

    private static ListNode sortDouble(ListNode[] listNodes, int start, int end) {
        if (start == end) {
            return sortDoubleListNodes(listNodes[start], null);
        } else if (start == end - 1) {
            return sortDoubleListNodes(listNodes[start], listNodes[end]);
        } else {
            if ((end - start) % 2 == 1) {
                return sortDoubleListNodes(sortDouble(listNodes, start, (start + end) / 2), sortDouble(listNodes, (start + end) / 2 + 1, end));
            } else {
                return sortDoubleListNodes(sortDouble(listNodes, start, (start + end) / 2 - 1), sortDouble(listNodes, (start + end) / 2, end));
            }
        }
    }

    private static ListNode sortDoubleListNodes(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode index = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                index.next = l2;
                l2 = l2.next;
            } else {
                index.next = l1;
                l1 = l1.next;
            }
            index = index.next;
        }
        index.next = l1 == null ? l2 : l1;
        return head.next;
    }

}
