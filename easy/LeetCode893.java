import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893. 特殊等价字符串组
 */
public class LeetCode893 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();

        for (String s : A) {
            int[] count = new int[56];
            // 前26为偶数位, 后26位奇数位  等价字符  序列话后相等
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)-'a'+26*(i%2)]++;
            }
            seen.add(Arrays.toString(count));
        }

        return seen.size();

    }
}
