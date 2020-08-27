package src;

import java.util.List;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class LeetCode19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy  = new ListNode(0);
        dummy.next=head;
        ListNode first  = dummy;
        ListNode second = dummy;
        for (int i =1;i<=n+1;i++){
            first = first.next;
        }
        while (first !=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;


    }
}
