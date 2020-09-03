/**
 * 1470. 重新排列数组
 */
public class LeetCode1470 {


    public int[] shuffle(int[] nums, int n) {

        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[i * 2] = nums[i];
            res[i * 2 + 1] = nums[n + i];
        }
        return res;

    }
}
