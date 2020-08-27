import java.util.HashMap;
import java.util.Map;

/**
 * 1207. 独一无二的出现次数
 */
public class LeetCode1207 {


    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        int i1 = map.values().stream().distinct().mapToInt(i->i).sum();
        int i2 = map.values().stream().mapToInt(i->i).sum();
        return i1==i2;
    }
}


