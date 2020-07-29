/**
 * 111. 二叉树的最小深度
 */
public class LeetCode111 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 先计算叶子节点 然后回溯 时间复杂度 O(N) N树的高度
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left ==null&&root.right==null){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(minDepth(root.left),min);
        }
        if(root.right != null){
            min = Math.min(minDepth(root.right),min);
        }
        return min+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left=root1;
        root.right=root2;
        root2.left =root3;
        root2.right = root4;
        System.out.println(minDepth(root));

    }




}
