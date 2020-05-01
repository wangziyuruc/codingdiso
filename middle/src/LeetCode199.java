package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 */
public class LeetCode199 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();
                // 从右面看  所以左侧添加
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                // 没层最后一个节点加入结果
                if (i == levelLength - 1) {
                    result.add(node.val);
                }
            }
        }


        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left2 = new TreeNode(5);
        TreeNode right2 = new TreeNode(4);
        root.left=left;
        root.right=right;
        left.right=left2;
//        right.right=right2;
        rightSideView(root).forEach(System.out::println);

    }
}



