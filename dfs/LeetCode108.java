/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class LeetCode108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int nums[];
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0,nums.length-1);
    }

    public TreeNode helper(int left,int right){
        if (left>right) return null;
        int p = (left+right)/2;
        TreeNode root = new TreeNode(nums[p]);
        root.left=helper(left,p-1);
        root.right = helper(p+1,right);
        return root;

    }
}
