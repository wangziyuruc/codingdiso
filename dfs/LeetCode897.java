import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序查找树
 */
public class LeetCode897 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root,vals);
        TreeNode ans = new TreeNode(0);
        TreeNode curr =ans;

        for (Integer val : vals) {
            curr.right=new TreeNode(val);
            curr=curr.right;
        }
        return ans.right;

    }

    public void inorder(TreeNode root, List<Integer> vals){
        if(root==null){
            return;
        }

        inorder(root.left,vals);
        vals.add(root.val);
        inorder(root.right,vals);
    }
}
