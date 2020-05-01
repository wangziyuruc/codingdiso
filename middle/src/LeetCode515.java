package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 */
public class LeetCode515 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {


        List<Integer> maxList = new ArrayList<>();
        if(root==null){
            return maxList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();


        queue.add(root);
        while (!queue.isEmpty()){
            int levelLength = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i=0;i<levelLength;i++){
                TreeNode node = queue.poll();
                if(max<node.val){
                    max=node.val;
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }

            }

            maxList.add(max);


        }

        return maxList;
    }
}
