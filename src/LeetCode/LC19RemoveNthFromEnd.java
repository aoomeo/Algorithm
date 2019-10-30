package LeetCode;

import java.util.Stack;

public class LC19RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ahead = new ListNode(2);
        ListNode bhead = new ListNode(3);
//        ListNode chead = new ListNode(4);
//        ListNode dhead = new ListNode(5);
        head.next = ahead;
        ahead.next = bhead;
//        bhead.next = chead;
//        chead.next = dhead;

        ListNode result = removeNthFromEnd(head, 3);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * description:
     * 使用了stack 去缓存，然后处理删除节点
     * 不够简洁，自己写的，有点烂。
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        Stack<ListNode> listNodes = new Stack<>();
        ListNode indexNode = head;
        while (indexNode != null) {
            listNodes.push(indexNode);
            indexNode = indexNode.next;
        }
        ListNode lastNode = null;
        while (n >= 0) {
            n--;
            if (n == 0) {
                listNodes.pop();
                if (lastNode == null) {
                    if (!listNodes.isEmpty()) listNodes.pop().next = null;
                    else return null;
                } else {
                    if (!listNodes.isEmpty()) listNodes.pop().next = lastNode;
                    else return lastNode;
                }
            } else {
                if (!listNodes.isEmpty()) {
                    lastNode = listNodes.pop();
                }
            }
        }
        return head;
    }

    /**
     * description:
     * first step : firstNode -> move N + 1
     * second step : firstNode , secondNode move together util firstNode == null
     * third step : secondNode.next = secondNode.next.next
     * fourth step : return start.next
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode a = start;
        ListNode b = start;
        for (; n >= 0; n--) {
            a = a.next;
        }
        if (a == null) {
            b.next = b.next.next;
        } else {
            while (a != null) {
                a = a.next;
                b = b.next;
                if (a == null) {
                    b.next = b.next.next;
                }
            }
        }
        return start.next;
    }

}
