package src;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 */
public class LeetCode863 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<TreeNode, TreeNode> parent;

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        // 初始化父链
        parent = new HashMap<>();
        dfs(root, null);
        Set<TreeNode> set = new HashSet<>();
        queue.add(target);
        set.add(target);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                if (level == K) {
                    for (TreeNode n : queue) {
                        result.add(n.val);
                    }
                    return result;
                }
                TreeNode node = queue.poll();
                // 左子树
                if (node.left != null && !set.contains(node.left)) {
                    queue.add(node.left);
                    set.add(node.left);
                }

                // 右子树
                if (node.right != null && !set.contains(node.right)) {
                    queue.add(node.right);
                    set.add(node.right);
                }
                // 父树
                if (parent.get(node) != null && !set.contains(parent.get(node))) {
                    TreeNode p = parent.get(node);

                    queue.add(p);
                    set.add(p);
                }
            }

            level++;


        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode863 l = new LeetCode863();
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);
        TreeNode ll2 = new TreeNode(6);
        TreeNode lr2 = new TreeNode(2);
        TreeNode rl2 = new TreeNode(0);
        TreeNode rr2 = new TreeNode(8);
        TreeNode ll3 = new TreeNode(7);
        TreeNode rr3 = new TreeNode(4);


        root.left = l1;
        root.right = r1;
        l1.left = ll2;
        l1.right = lr2;
        r1.left = rl2;
        r1.right = rr2;
        lr2.left = ll3;
        lr2.right = rr3;
        l.distanceK(root, l1, 2).forEach(System.out::println);

    }
}
