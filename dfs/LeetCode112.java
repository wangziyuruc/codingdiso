/**
 * 112. 路径总和
 */
public class LeetCode112 {
    class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        sum-=root.val;
        if(root.left==null&&root.right==null){
            return sum==0;
        }
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);

    }

}
