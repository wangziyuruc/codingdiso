import com.sun.beans.editors.EnumEditor;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class LeetCode117 {


    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }


    }

    ;


    public Node connect(Node root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNode(root);
        }
        if (root.left == null) {
            root.right.next = getNextNode(root);
        }
        if (root.right == null) {
            root.left.next = getNextNode(root);
        }

        //这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        root.right = connect(root.right);
        root.left = connect(root.left);
        return root;

    }


    public Node getNextNode(Node root){
        while (root.next!=null){
            if(root.next.left !=null){
                return root.next.left;
            }
            if(root.next.right !=null){
                return root.next.right;
            }
        }
        return null;
    }



}
