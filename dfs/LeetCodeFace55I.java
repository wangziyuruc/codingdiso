/**
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class LeetCodeFace55I {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

    }
}
