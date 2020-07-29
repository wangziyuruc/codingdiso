import java.util.List;

/**
 *面试题 04.12. 求和路径
 */
public class LeetCodeFace0412 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int res =0;
    public int pathSum(TreeNode root, int sum) {
        int dep = depth(root);
        int[] path = new int[dep];
        pathSum(root,sum,0,path);
        return res;

    }

    public void pathSum(TreeNode root,int sum,int level,int[] path){
        if(root==null){
            return;
        }
        path[level] = root.val;

        int t=0;
        for (int i=level;i>=0;i--){
            t+=path[i];
            if(t==sum){
                res+=1;
            }

        }
        pathSum(root.left,sum,level+1,path);
        pathSum(root.right,sum,level+1,path);

    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(depth(root.left),depth(root.right))+1;
    }


}
