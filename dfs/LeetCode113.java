import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
public class LeetCode113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        sum(res,cur,root,sum);
        return res;

    }

    private void sum(List<List<Integer>> res, List<Integer> cur, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        cur.add(node.val);
        if (node.val==sum&&node.left==null&&node.right==null){
            res.add(new ArrayList<>(cur));
        }else {
            sum(res,cur,node.left,sum-node.val);
            sum(res,cur,node.right,sum-node.val);
        }
        cur.remove(cur.size()-1);
    }
}
