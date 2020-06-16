/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class LeetCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    public void dfs(Node root){
        if(root==null){
            return;
        }
        Node left = root.left;
        Node right = root.right;
        while (left !=null){
            left.next=right;
            left = left.right;
            right = right.left;
        }

        dfs(root.left);
        dfs(root.right);
    }
}