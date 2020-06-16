/**
 * 114. 二叉树展开为链表
 */
public class LeetCode114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if(root ==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        // 记录右子树
        TreeNode right = root.right;

        // 把树的左子树赋值到右子树
        root.right= root.left;
        // 左子树为null
        root.left=null;
        // 找到 左子树交替后的最右侧节点
        while (root.right!=null) {root = root.right;}
        // 右子树拼接
        root.right = right;



    }
}
