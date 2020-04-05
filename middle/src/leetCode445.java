package src;

import java.util.Stack;

public class leetCode445 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    // 利用栈
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode p = l1;
        ListNode q = l2;

        while (p != null || q != null) {
            if ((p != null)) {
                stack1.push(p.val);
            }
            if ((q != null)) {
                stack2.push(q.val);
            }
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        ListNode dummyNode = new ListNode(0);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = !stack1.isEmpty() ? stack1.pop() : 0;
            int num2 = !stack2.isEmpty() ? stack2.pop() : 0;
            int sum = num1 + num2 + carry;
            ListNode curr = dummyNode.next;
            dummyNode.next = new ListNode(sum % 10);
            dummyNode.next.next = curr;
            carry=sum/10;

        }
        if(carry>0){
            ListNode curr = dummyNode.next;
            dummyNode.next = new ListNode(carry);
            dummyNode.next.next = curr;
        }

        return dummyNode.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        String num1 = "";
        String num2 = "";
        while (l1 != null || l2 != null) {
            num1 = (l1 != null) ? num1 + l1.val : num1;
            num2 = (l2 != null) ? num2 + l2.val : num2;

            if (l1 != null) l1 = l1.next;

            if (l2 != null) l2 = l2.next;
        }
        long sum = Long.parseLong(num1) + Long.parseLong(num2);
        // 都是零的情况
        if (sum == 0) {
            return new ListNode(0);
        }
        System.out.println(sum);
        ListNode dummyNode = new ListNode(0);
        ListNode curr = null;

        while (sum % 10 > 0 || sum / 10 > 0) {

            ListNode tmp = new ListNode(Integer.parseInt(String.valueOf(sum % 10)));
            curr = dummyNode.next;
            dummyNode.next = tmp;
            tmp.next = curr;
            sum = sum / 10;
        }

        return dummyNode.next;
    }


    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyNode;
        int carry = 0;
        while (p != null || q != null) {
            int num1 = (p != null) ? p.val : 0;
            int num2 = (q != null) ? q.val : 0;
            int sum = carry + num1 + num2;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode A = new ListNode(5);
        ListNode A1 = new ListNode(4);
        ListNode A2 = new ListNode(3);
//        A.next = A1;
//        A1.next = A2;

        ListNode B = new ListNode(5);
        ListNode B1 = new ListNode(9);
        ListNode B2 = new ListNode(4);
//        B.next = B1;
//        B1.next = B2;

        ListNode sum = addTwoNumbers(A, B);
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
