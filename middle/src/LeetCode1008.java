package src;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1008. 先序遍历构造二叉树
 */
public class LeetCode1008 {

    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n ==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        for (int i = 1; i < n; i++) {
            TreeNode node = deque.peek();
            TreeNode child = new TreeNode(preorder[i]);
            while (!deque.isEmpty() && deque.peek().val<child.val){
                node = deque.pop();
            }
            if (node.val < child.val) node.right =child;
            else node.left = child;
            deque.push(child);
        }
        return root;

    }
}
