package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题32 - III. 从上到下打印二叉树 III
 */
public class LeetCodeFace32 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int row =0;
        while (!queue.isEmpty()){
            result.add(new ArrayList<>());
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node =queue.poll();
                if(row%2==0){
                    result.get(row).add(node.val);
                }else {
                    result.get(row).add(0,node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
            row++;
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode right1 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left= right1;
        right.right = right2;
        for (List<Integer> l : levelOrder(root)){
            for (Integer v :l){
                System.out.print(v+" ");

            }
            System.out.println();
        }
    }
}
