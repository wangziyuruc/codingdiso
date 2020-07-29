/**
 *面试题 04.05. 合法二叉搜索树
 */
public class LeetCodeFace0405 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null || (root.left ==null && root.right ==null)) return true;

        boolean r1= root==null || helper(root.left,Long.MIN_VALUE,root.val);
        boolean r2= root==null || helper(root.right,root.val,Long.MAX_VALUE);
        return r1&&r2;
    }

    public boolean helper(TreeNode root,long min,long max){
        if(root == null) return true;

        if (root.val<= min || root.val >=max) return false;

        boolean r1= root==null || helper(root.left,min,root.val);
        boolean r2= root==null || helper(root.right,root.val,max);
        return r1&&r2;
    }
}
