import java.util.ArrayList;
import java.util.List;

/**
 * 491. 递增子序列
 */
public class LeetCode491 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, int index) {
        // 递归终止条件
        if (index >= nums.length) {
            if (list.size() >= 2) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        // index节点加入队列 满足条件加入队列
        if (list.isEmpty() || nums[index] >= list.get(list.size() - 1)) {
            list.add(nums[index]);
            dfs(nums, list, index + 1);
            list.remove(list.size() - 1);
        }
        if (index > 0 && !list.isEmpty() && nums[index] == list.get(list.size() - 1)) {
            return;
        }
        // 不把index节点加入队列
        dfs(nums, list, index + 1);
    }
}
