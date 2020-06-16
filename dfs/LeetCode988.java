/**
 * 988. 从叶结点开始的最小字符串
 */
public class LeetCode988 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String min = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuffer());
        return min;
    }

    public void dfs(TreeNode root,StringBuffer sb) {
        if(root==null){
            return;
        }
        sb.append((char)('a'+root.val));
        // 判断当前节点是叶子节点
        if(root.left == null&&root.right==null){
            sb.reverse();
            String s = sb.toString();
            sb.reverse();
            if(s.compareTo(min)<0){
                min=s;
            }

        }
        dfs(root.left,sb);
        dfs(root.right,sb);
        // 回溯过程中去掉尾部
        sb.deleteCharAt(sb.length()-1);
    }
}
