import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class LeetCodeFace2T34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        if (root == null) return ans;
        pathSumHelper(new ArrayList<>(),root,sum,0);
        return ans;
    }



    public void pathSumHelper(List<Integer> path, TreeNode root, int sum, int cur) {
        cur += root.val;
        path.add(root.val);
        if (sum == cur && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            pathSumHelper(path, root.left, sum, cur);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            pathSumHelper(path, root.right, sum, cur);
            path.remove(path.size() - 1);
        }
    }
}
