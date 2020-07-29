import java.util.HashMap;
import java.util.Map;

/**
 * 1530. 好叶子节点对的数量
 */
public class LeetCode1530 {


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

    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return ans;
    }

    public Map<TreeNode, Integer> dfs(TreeNode root, int d) {
        Map<TreeNode, Integer> ret = new HashMap<>();
        if (root == null) {
            return ret;
        }
        // 當前是葉子結點，記錄葉子結點到其父節點的距離
        if (root.left == null && root.right == null) {
            ret.put(root, 1);
            return ret;
        }
        Map<TreeNode, Integer> left = dfs(root.left, d);
        Map<TreeNode, Integer> right = dfs(root.right, d);

        // 統計當前根結點的左右子樹的好結點
        for (TreeNode lk : left.keySet()) {
            for (TreeNode rk : right.keySet()) {
                if (left.get(lk)+right.get(rk)<=d){
                    ans++;
                }
            }
        }
        for (TreeNode lk : left.keySet()) {
            if (left.get(lk) + 1 < d) {
                ret.put(lk, left.get(lk) + 1);
            }
        }

        for (TreeNode rk : right.keySet()) {
            if (right.get(rk) + 1 < d) {
                ret.put(rk, right.get(rk) + 1);
            }
        }
        return ret;
    }
}
