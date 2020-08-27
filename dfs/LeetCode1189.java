import java.util.HashMap;
import java.util.Map;

/**
 * 1189. “气球” 的最大数量
 */
public class LeetCode1189 {


    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : text.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        return Math.min(Math.min(Math.min(Math.min(map.getOrDefault('b',0),
                map.getOrDefault('a',0)),
                map.getOrDefault('l',0)/2),
                map.getOrDefault('o',0)/2),
                map.getOrDefault('n',0));

    }

    public static void main(String[] args) {

    }
}
