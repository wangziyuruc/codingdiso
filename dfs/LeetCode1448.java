/**
 * 1448. 统计二叉树中好节点的数目
 */
public class LeetCode1448 {

    public static class TreeNode {
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

    // 好节点个数  单独提取出来在整个递归过程中共享变量
    int num =0;
    public  int goodNodes(TreeNode root) {
        if(root ==null){
            return 0;
        }
        count(root,root.val);
        return num;
    }
    public  void count(TreeNode root,int curMax){
        if(root == null){
          return;
        }
        if(root.val>=curMax){
            num++;
        }
        // 记录当前最大值点
        count(root.left,Math.max(curMax,root.val));
        count(root.right,Math.max(curMax,root.val));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(5);
        root.left=root1;
        root.right=root2;
        root1.left=root3;
        root2.left=root4;
        root2.right=root5;
        System.out.println(new LeetCode1448().goodNodes(root));

    }
}
