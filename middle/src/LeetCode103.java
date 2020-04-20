package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层次遍历
 */
public class LeetCode103 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if(root==null){
            return levels;
        }
        int level = 0; // 奇偶 进行之遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            levels.add(new ArrayList<>());
            int levelLength = queue.size();
            for (int i=0;i<levelLength;i++){
                TreeNode treeNode=queue.poll();


                if(level%2 == 0){
                    // 偶数层
                    levels.get(level).add(treeNode.val);

                }else {
                    // 奇数层
                    levels.get(level).add(0,treeNode.val);

                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
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
        zigzagLevelOrder(root).forEach(s->{s.forEach(System.out::println);});
    }


}
