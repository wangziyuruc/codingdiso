import java.nio.IntBuffer;

/**
 * 109. 有序链表转换二叉搜索树
 */
public class LeetCode109 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ListNode findMiddleElement(ListNode head){
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        // 快慢指针
        while (fast !=null && fast.next !=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断链
        if(pre != null){
            pre.next = null;
        }
        return slow;
    }


    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        // 每次寻找中位数 中位数两侧数据个数相等
        ListNode mid = this.findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if(head == mid){
            return node;
        }
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }

}
