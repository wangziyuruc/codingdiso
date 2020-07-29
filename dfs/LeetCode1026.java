/**
 * 1026. 节点与其祖先之间的最大差值
 */
public class LeetCode1026 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int max=0;
    public int maxAncestorDiff(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root,root.val,root.val);
        return max;
    }

    private void dfs(TreeNode node,int maxV,int minV){
        if(node == null){
            return;
        }
        maxV = Math.max(maxV,node.val);
        minV = Math.min(minV,node.val);
        int max1 = Math.max(Math.abs(node.val-maxV),Math.abs(node.val-minV));
        max = Math.max(max1,max);


        dfs(node.left,maxV,minV);
        dfs(node.right,maxV,minV);
    }

}
