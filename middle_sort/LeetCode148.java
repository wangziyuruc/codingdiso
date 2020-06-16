/**
 * 148. 排序链表
 */
public class LeetCode148 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public ListNode sortList(ListNode head) {
          if(head == null){
              return null;
          }
          if(head.next==null){
              return head;
          }
          ListNode p1 = head;
          ListNode p2 = head;
          while (p2.next!=null&&p2.next.next!=null){
              p1=p1.next;
              p2=p2.next.next;
          }
          ListNode tail = p1;
          p1=p1.next;
          tail.next=null;
          ListNode L = sortList(head);
          ListNode R = sortList(p1);
          return merge(L,R);


    }

    public ListNode merge(ListNode left,ListNode right){
          ListNode pre = new ListNode(0);
          ListNode curr = pre;
          while (left!=null && right !=null){
              if(left.val<=right.val){
                  curr.next=left;
                  curr =curr.next;
                  left=left.next;
              }else {
                  curr.next = right;
                  curr=curr.next;
                  right=right.next;
              }
          }

          if(left!=null){
              curr.next=left;
          }
          if(right!=null){
              curr.next=right;
          }

          return pre.next;
    }
}
