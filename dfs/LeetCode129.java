/**
 * 129. 求根到叶子节点数字之和
 */
public class LeetCode129 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return  0;
        }
        return sum(root,0);

    }

    public static int sum(TreeNode node,int curValue){
        if(node == null){
            return curValue;
        }

         curValue = curValue*10+node.val;
        if(node.left==null && node.right==null){
            return curValue;
        }
        // 计算左右子树的和
        return sum(node.left,curValue)+sum(node.right,curValue);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left=left;
        root.right=right;
        sumNumbers(root);
    }
}
