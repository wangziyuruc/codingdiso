package src;

import java.awt.im.InputMethodHighlight;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 */
public class LeetCode513 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int findBottomLeftValue(TreeNode root) {
        int reslut = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        reslut=root.val;
        while (!queue.isEmpty()){
            int levelLength = queue.size();
            for(int i=0;i<levelLength;i++){
                TreeNode node = queue.poll();
                // 每层第一个数据
                if(i==0){
                    reslut = node.val;
                }
                if(node.left !=null){
                    queue.add(node.left);
                }
                if(node.right !=null){
                    queue.add(node.right);
                }
            }

        }
        return reslut;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(4);
        root.left=left;
        root.right=right;
        left.right=left1;
        System.out.println(findBottomLeftValue(root));
    }
}
