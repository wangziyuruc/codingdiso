/**
 * 面试题 04.04. 检查平衡性
 */
public class LeetCodeFace0404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            return Math.abs(heght(root.left)-heght(root.right))<2&&isBalanced(root.left)&&isBalanced(root.right);

        }

        public int heght(TreeNode node){
            if(node == null){
                return -1;
            }
            return 1+Math.max(heght(node.left),heght(node.right));
        }
    }
}
