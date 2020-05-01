package src;

/**
 * 98. 验证二叉搜索树
 */
public class LeetCode98 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;

        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static boolean isValidBST3(TreeNode root,Integer lower,Integer high){
        if (root == null) {
            return true;
        }
        Integer value =root.val;
        if (lower != null && value <= lower) {
            return false;

        }
        if (high != null && value >= high) {
            return false;
        }
        if(isValidBST3(root.left,lower,value))
            return false;
        if(isValidBST3(root.right,value,high))
            return false;
        return true;
    }


    public static boolean isValidBST2(TreeNode root) {
        return isValidBST3(root,null,null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);

        System.out.println(isValidBST2(root));



    }
}
