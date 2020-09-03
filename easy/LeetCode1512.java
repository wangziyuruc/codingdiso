import java.util.HashMap;
import java.util.Map;

/**
 * 1512. 好数对的数目
 */
public class LeetCode1512 {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : m.entrySet()) {
            int v = integerIntegerEntry.getValue();
            ans += v * (v - 1) / 2;
        }
        return ans;

    }
}
