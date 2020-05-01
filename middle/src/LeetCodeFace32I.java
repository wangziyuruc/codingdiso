package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题32 - I. 从上到下打印二叉树
 */
public class LeetCodeFace32I {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if(root ==null){
            return null;

        }
        Queue<TreeNode > queue = new ArrayDeque<>();
        queue.add(root);
        int i= 0;
        List<Integer> result=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            result.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }

            if(node.right!=null){
                queue.add(node.right);
            }
            i++;

        }
        int[] res = new int[result.size()];
        int n  =0;
        for (Integer r:result){
            res[n]=r;
            n++;
        }

        return res;

    }
}
