import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class LeetCode257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        dfs(root,"",paths);
        return paths;
    }

    public void dfs(TreeNode node, String path, LinkedList<String> paths){
        if(node !=null){
            path+= node.val;
            if(node.left ==null&&node.right==null){
                paths.add(path);
            }else {
                path+="->";
                dfs(node.left,path,paths);
                dfs(node.right,path,paths);
            }
        }
    }
}
