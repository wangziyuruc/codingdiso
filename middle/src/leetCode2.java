package src;

public class leetCode2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode sum = null;
        ListNode tempNode = null;

        while (l1 != null || l2 != null) {
            int num1 = (l1!= null)? l1.val:0;
            int num2 = (l2!=null)?l2.val:0;


            int sumTemp = num1 + num2;
            int nodeValue = sumTemp % 10;
            if (sum != null) {
                tempNode.next = new ListNode((temp + nodeValue) % 10);
                tempNode = tempNode.next;
            }

            if (sum == null) {
                sum = new ListNode((temp + nodeValue) % 10);
                tempNode = sum;

            }
            temp = (temp + sumTemp) / 10;


            if (l1 != null) {
                l1 = l1.next;

            }
            if (l2 != null) {
                l2 = l2.next;

            }

            if (l1 == null && l2 == null && temp > 0) {
                tempNode.next = new ListNode(temp % 10);
                tempNode = tempNode.next;
            }

        }
        return sum;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int num1 = 0;
        int num2 = 0;
        int i = 1;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                num1 = i * l1.val + num1;
            }
            if (l2 != null) {
                num2 = i * l2.val + num2;
            }
            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
            i=i*10;
        }
        int sum = num1+num2;
        System.out.println(sum);
        ListNode sumNode = null;
        ListNode tempNode = null;
        while (sum/10>0 || sum %10 >0){
            if(sumNode != null){
                tempNode.next = new ListNode(sum%10);
                tempNode = tempNode.next;
            }

            if(sumNode ==null){
                sumNode=new ListNode(sum%10);
                tempNode = sumNode;
            }
            sum = sum/10;

        }
        return sumNode;
    }


    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyNode;
        int carry = 0;
        while (p!=null ||q!=null){
            int num1= (p!=null)?p.val:0;
            int num2 = (q!=null)?q.val:0;
            int sum = carry+num1+num2;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            carry = sum/10;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }

        if (carry > 0){
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

        ListNode sum = addTwoNumbers3(A, B);
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
