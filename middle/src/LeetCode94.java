package src;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 94. 二叉树的中序遍历
 */
public class LeetCode94 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> reslut = new ArrayList<>();
        if (root==null){
            return reslut;
        }
        middleTraverse(root,reslut);
        return reslut;
    }

    public static void middleTraverse(TreeNode root,List<Integer> res){
        if (root == null){
            return;
        }

        middleTraverse(root.left,res);
        res.add(root.val);
        middleTraverse(root.right,res);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode root1= new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        root.left=root1;
        root.right=root2;
        inorderTraversal(root).stream().forEach(System.out::println);

    }
}
