package LeetCode;

public class LC21MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
