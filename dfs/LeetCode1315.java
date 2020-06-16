import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 1315. 祖父节点值为偶数的节点和
 */
public class LeetCode1315 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int sum = 0;

    public static int sumEvenGrandparent(TreeNode root) {
        // 小细节  当前节点是子节点的父节点，当前节点的父节点是祖父节点,交替
        dfs(null,null,root);
        return sum;
    }

    public static void dfs(TreeNode grandParent, TreeNode parent, TreeNode root) {
        if (root == null) {
            return;
        }
        // 偶数判断
        if(grandParent != null && (grandParent.val & 1) == 0){
            sum+=root.val;
        }
       dfs(parent,root,root.left);
       dfs(parent,root,root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode root1 = new TreeNode(7);
        TreeNode root2 = new TreeNode(8);
        root.left = root1;
        root.right=root2;
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(7);
        TreeNode root5 = new TreeNode(1);
        TreeNode root6 = new TreeNode(3);
        root1.left=root3;
        root1.right=root4;
        root2.left=root5;
        root2.right=root6;
        TreeNode root7 = new TreeNode(9);
        root3.left=root7;
        TreeNode root8 = new TreeNode(1);
        TreeNode root9 = new TreeNode(4);
        root4.left=root8;
        root4.right=root9;
        TreeNode root10 = new TreeNode(5);
        root6.right=root10;
        System.out.println(sumEvenGrandparent(root));

    }

}
