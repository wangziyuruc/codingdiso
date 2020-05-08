package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题 04.03. 特定深度节点链表
 */
public class LeetCode0403 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode[] listOfDepth(TreeNode tree) {

        if (tree == null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(tree);
        int row = 0;
        while (!queue.isEmpty()) {
            res.add(new ArrayList<>());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.get(row).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            row++;
        }
        ListNode[] listNode = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            ListNode tail=new ListNode(list.get(0));
            listNode[i]=tail;

            for (int j=1;j<list.size();j++){
                tail.next=new ListNode(list.get(j));
                tail = tail.next;
            }


        }
        return listNode;
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        TreeNode root1 =new TreeNode(2);
        TreeNode root2 =new TreeNode(3);
        TreeNode root3 =new TreeNode(4);
        TreeNode root4 =new TreeNode(5);
        TreeNode root5 =new TreeNode(7);
        TreeNode root6 =new TreeNode(8);
        root.left=root1;
        root.right=root2;

        root1.left=root3;
        root1.right=root4;

        root2.right=root5;
        root3.left = root6;
        listOfDepth(root);
    }
}
