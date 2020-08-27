import java.util.List;

/**
 * 面试题 02.03. 删除中间节点
 */
public class Face0203 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
       node.val = node.next.val;
       node.next = node.next.next;

    }
}
