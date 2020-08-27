import java.util.List;

/**
 * 21. 合并两个有序链表
 */
public class LeetCode21 {
    public class ListNode {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                curr.next = l2;

                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;

        }
     curr.next = l1 == null? l2:l1;

        return head.next;

    }

}
