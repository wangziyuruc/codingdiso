/**
 * 1145. 二叉树着色游戏
 */
public class LeetCode1145 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 计算以node节点为根的树的节点的树木
     * @param node
     * @return
     */
    public int countNode(TreeNode node){
        if(node == null){
            return 0;
        }else {
            return countNode(node.left)+countNode(node.right)+1;
        }
    }

    public TreeNode find(TreeNode node,int x){
        if(node == null){
            return null;
        }
        if(node.val==x){ return node;}
        TreeNode left = find(node.left,x);
        TreeNode right = find(node.right,x);
        if(left==null){
            return right;
        }else {
            return left;
        }

    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if(root == null){return false;}
        TreeNode node = find(root,x);
        int sl = countNode(node.left);
        int sr = countNode(node.right);
        if(sl>n/2 || sr > n/2 || (sl+sr+1)<=n/2){return true;}
        else {return false;}


    }
}
