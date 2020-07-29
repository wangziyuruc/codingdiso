/**
 * 面试题 04.06. 后继者
 */
public class LeetCodeFace0406 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean flag = false;

    TreeNode aimNode;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null ){
            return aimNode;
        }
        inorderSuccessor(root.left,p);

        if(root==p){
            flag=true;
        }else if(flag){
            aimNode=root;
            flag=false;
        }
        inorderSuccessor(root.right,p);
        return aimNode;
    }
}
