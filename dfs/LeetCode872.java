import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 */
public class LeetCode872 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1,leaves1);
        dfs(root2,leaves2);
        return leaves1.equals(leaves2);

    }

    public void dfs(TreeNode node , List<Integer> leafValues){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null){
            leafValues.add(node.val);
        }
        dfs(node.left,leafValues);
        dfs(node.right,leafValues);

    }
}
