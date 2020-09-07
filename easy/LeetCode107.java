import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 */
public class LeetCode107 {

    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }



    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }


        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.value);
                if (node.left !=null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }


            }
            result.add(0,tmp);
        }

        return result;



    }
}
