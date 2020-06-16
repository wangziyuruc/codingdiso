/**
 * 979. 在二叉树中分配硬币
 */
public class LeetCode979 {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int ans;
    public int distributeCoins(TreeNode root) {
        ans =0;
        dfs(root);
        return ans;

    }
    // 以root为根的子树的的金币量-树的节点个数 就是需要移动的次数
    public int dfs(TreeNode root){
        if(root==null) {
            return 0;
        }
        int L = dfs(root.left);
        int R = dfs(root.right);
        ans += Math.abs(L)+Math.abs(R);
        return root.val+L+R-1;

    }
}
