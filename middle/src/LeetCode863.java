package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 863. 二叉树中所有距离为 K 的结点
 */
public class LeetCode863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> levels = new ArrayList<>();
        int level=1;
        while (!queue.isEmpty()){
            int levelLength = queue.size();
            for(int i=0;i<levelLength;i++){

            }

        }

        return result;
    }

    public static void main(String[] args) {

    }
}
