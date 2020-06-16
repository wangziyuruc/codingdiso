/**
 * 1302. 层数最深叶子节点的和
 */
public class LeetCode1302 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private int depLevel = 0;
    private int sum =0;

    public void dfs(TreeNode root,int dep){
        if(root==null){
            return;
        }
        dep++;
        if(dep>depLevel){
            depLevel=dep;
            sum=root.val;
        }else if(dep==depLevel){
            sum+=root.val;
        }
        dfs(root.left,dep);
        dfs(root.right,dep);
    }

    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return sum;
    }
}
