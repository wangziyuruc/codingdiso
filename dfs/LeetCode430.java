/**
 * 430. 扁平化多级双向链表
 */
public class LeetCode430 {


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    };


    public Node flatten(Node head) {
        if(head == null)
            return head;

        Node pseudoHead = new Node(0,null,head,null);
        flattenDfs(pseudoHead,head);
        pseudoHead.next.prev = null;
        return pseudoHead.next;


    }


    public Node flattenDfs(Node prev,Node curr){
        if(curr == null){
            return prev;
        }
        curr.prev = prev;
        prev.next = curr;


        Node temp = curr.next;

        Node tail = flattenDfs(curr,curr.child);
        curr.child = null;

        return flattenDfs(tail,temp);
    }
}
