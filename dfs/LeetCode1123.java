/**
 * 1123. 最深叶节点的最近公共祖先
 */
public class LeetCode1123 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null){
            return null;
        }
        int ld = dfs(root.left);
        int rd = dfs(root.right);
        if(ld==rd){
            return root;
        }else if(ld>rd){
            return lcaDeepestLeaves(root.left);
        }else {
            return lcaDeepestLeaves(root.right);
        }

    }

    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        return Math.max(left,right)+1;
    }
}
