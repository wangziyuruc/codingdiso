/**
 * 剑指 Offer 55 - II. 平衡二叉树
 */
public class LeetCodeOffer55 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(height(root.left)-height(root.right))<2
                && isBalanced(root.left)&&isBalanced(root.right);

    }
    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
