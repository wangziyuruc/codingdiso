package src;

import java.util.Stack;

public class leetCode86 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    // 利用栈
    public static ListNode partition(ListNode head, int x) {
        ListNode currTemp = head;
        // 链表拆分
        ListNode minNode = new ListNode(0);
        ListNode lastMinNode = minNode;
        ListNode maxNode = new ListNode(0);
        ListNode lastMaxNode = maxNode;
        while (currTemp != null) {
            if (currTemp.val < x) {
                lastMinNode.next = new ListNode(currTemp.val);
                lastMinNode = lastMinNode.next;

            }else {
                lastMaxNode.next = new ListNode(currTemp.val);
                lastMaxNode = lastMaxNode.next;
            }
            currTemp = currTemp.next;
        }


        // 链表合并
        lastMaxNode.next=null;
        lastMinNode.next=maxNode.next;
        return minNode.next;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(2);
        ListNode A1 = new ListNode(1);
        ListNode A2 = new ListNode(3);
        ListNode A3 = new ListNode(2);
        ListNode A4 = new ListNode(5);
        ListNode A5 = new ListNode(2);
        A.next = A1;
        A2.next = A3;
        A3.next = A4;
        A4.next = A5;


        ListNode sum = partition(A, 3);
        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
