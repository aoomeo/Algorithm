package LeetCode;

public class LC02AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2;
        ListNode node3;
        node1.next = node2 = new ListNode(4);
        node2.next = node3 = new ListNode(3);

        ListNode node4 = new ListNode(9);
        ListNode node5;
        ListNode node6;
        node4.next = node5 = new ListNode(9);
        node5.next = node6 = new ListNode(7);

        ListNode result = addTwoNumbers(node1, node4);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode firstA, ListNode firstB) {
        int flag = 0;
        ListNode result = null;
        ListNode indexNode = null;
        while (firstA != null || firstB != null || flag == 1) {
            int sum = 0;
            if (firstA != null) {
                sum += firstA.val;
            }
            if (firstB != null) {
                sum += firstB.val;
            }
            sum += flag;
            flag = sum / 10;
            sum = sum % 10;
            if (result == null) {
                result = new ListNode(sum);
                indexNode = result;
            } else {
                ListNode tmp = new ListNode(sum);
                indexNode.next = tmp;
                indexNode = tmp;
            }
            if (firstA != null) firstA = firstA.next;
            if (firstB != null) firstB = firstB.next;
        }
        return result;

    }

}
