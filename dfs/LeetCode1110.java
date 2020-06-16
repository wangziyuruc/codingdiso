import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 1110. 删点成林
 */
public class LeetCode1110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private LinkedList<TreeNode> res = new LinkedList<TreeNode>();
    private HashSet<Integer> delete_set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        delete_set = new HashSet<>();
        for (int i : to_delete) {
            delete_set.add(i);
        }
        dfs(root,true);
        return res;
    }


    private boolean dfs(TreeNode root,boolean isAdd){
        if(root!=null){
            if(delete_set.contains(root.val)){
                if(dfs(root.left,true)) {root.left=null;}
                if(dfs(root.right,true)) {root.right=null;}
                return true;


            }

            if(isAdd){
                res.add(root);
            }
            if(dfs(root.left,false)) {root.left=null;}
            if(dfs(root.right,false)) {root.right=null;}        }
        return false;
    }
}
