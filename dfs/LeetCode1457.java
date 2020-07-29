/**
 * 1457. 二叉树中的伪回文路径
 */
public class LeetCode1457 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null){return 0;}
        dfs(root,0);
        return ans;
    }

    public void dfs(TreeNode node,int temp){
        temp ^= (1<<node.val);
        if(node.left ==null && node.right == null){
            if(temp == 0 || (temp&(temp-1))==0){
                ans++;
            }
        }
        if(node.left != null){dfs(node.left,temp);}
        if(node.right != null){dfs(node.right,temp);}

    }
}
