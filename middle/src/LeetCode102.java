package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 */
public class LeetCode102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root==null){
            return levels;
        }
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);


        int level=0;


        while (!treeNodes.isEmpty()){
            levels.add(new ArrayList<>());
            // 通过长度计算每一层限制条件
            int  levelSize= treeNodes.size();
            for (int i=0;i<levelSize;i++){
                TreeNode treeNode = treeNodes.poll();
                levels.get(level).add(treeNode.val);
                if(treeNode.left !=null){
                    treeNodes.add(treeNode.left);
                }

                if(treeNode.right !=null){
                    treeNodes.add(treeNode.right);
                }
            }

            level++;
        }
        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        root.left=left;
        root.right=right;
        right.left=left2;
        right.right=right2;
        levelOrder(root).forEach(s->{s.forEach(System.out::println);});

    }


}
