import java.util.ArrayList;
import java.util.List;

/**
 * \971. 翻转二叉树以匹配先序遍历
 * @author zy
 */
public class LeetCode971 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> res;
    int index;
    int[] voyage;
    // 时间复杂度 O(N) 空间复杂度 O(N)
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        res = new ArrayList<>();
        index=0;
        this.voyage = voyage;
        dfs(root);
        if(!res.isEmpty()&&res.get(0)==-1){
            res.clear();
            res.add(-1);
        }
        return res;
    }

    public void dfs(TreeNode treeNode){
        if(treeNode !=null){
            // 先序遍历的 父节点处理
            if(treeNode.val != voyage[index++]){
                res.clear();
                res.add(-1);
                return;
            }
            // 先序遍历的左子树处理
            if(index<voyage.length
                    && treeNode.left != null
                    && treeNode.left.val != voyage[index]){
                // 左子树节点的值与序列中的数据不相等
                res.add(treeNode.val);
                // 先访问右子树 作为交换节点值
                dfs(treeNode.right);
                dfs(treeNode.left);

            }else {
                // 先序遍历的右子树处理
                dfs(treeNode.left);
                dfs(treeNode.right);
            }



        }

    }


}
