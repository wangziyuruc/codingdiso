/**
 * 1080. 根到叶路径上的不足节点
 */
public class LeetCode1080 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean delete = dfs(root,0,limit);
        if(delete){
            return null;
        }
        return root;
    }

    public boolean dfs(TreeNode node,int s,int limit){
        if(node.left==null&&node.right==null){
            return s+node.val<limit;
        }

        boolean ldelete = true;
        boolean rdelete = true;
        if(node.left!=null){
            ldelete=dfs(node.left,s+node.val,limit);
        }
        if(node.right != null){
            rdelete=dfs(node.right,s+node.val,limit);
        }
        if(ldelete){
            node.left=null;
        }
        if(rdelete){
            node.right=null;
        }
        return ldelete&&rdelete;
    }
}
