import java.util.Arrays;

/**
 *面试题 04.02. 最小高度树
 */
public class LeetCodeFace0402 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        TreeNode node = new TreeNode(nums[nums.length/2]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return node;
    }
}
