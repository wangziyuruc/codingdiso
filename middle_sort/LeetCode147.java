import java.util.List;

/**
 * 147. 对链表进行插入排序
 */
public class LeetCode147 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next==null){
            return head;

        }
        ListNode res = new ListNode(Integer.MIN_VALUE);
        res.next = head;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null){
            if (pre.val <= curr.val){
                pre=curr;
                curr=curr.next;
            }else {

                ListNode p = res;
                // 查找 位置 p<curr
                while (p.next !=curr && p.next.val<curr.val){
                    p=p.next;
                }
                ListNode next = p.next;
                pre.next = curr.next;
                curr.next=next;
                p.next=curr;
                curr=pre.next;


            }
        }




        return res.next;

    }

    public static void main(String[] args) {

    }
}
